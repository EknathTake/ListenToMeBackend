package com.listenme.web;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.listenme.domain.entity.Action;
import com.listenme.process.api.ListenMeProcess;

@RestController
public class ListenMeRestController {

	@Inject
	@Named("listenMeProcess")
	private ListenMeProcess listenMeProcess;

	@RequestMapping(method = RequestMethod.POST, path = "/action")
	public List<Action> saveActions() {
		return listenMeProcess.saveActions();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/action")
	public Set<Action> predictPossibleActions(@RequestParam(name = "ip") String input) {
		return listenMeProcess.predictPossibleActions(input);
	}

}
