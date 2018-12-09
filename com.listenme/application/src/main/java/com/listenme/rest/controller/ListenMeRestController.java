package com.listenme.rest.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.listenme.domain.model.Action;
import com.listenme.domain.model.Activity;
import com.listenme.process.api.ListenMeProcess;
import com.listenme.rest.controller.response.ListenMeRestControllerResponse;

@RestController
public class ListenMeRestController {

	@Inject
	@Named("listenMeProcess")
	private ListenMeProcess listenMeProcess;

	@GetMapping(path = "/train")
	public ListenMeRestControllerResponse train() {
		listenMeProcess.train();
		return null;
	}

	@PostMapping(path = "/action")
	public ListenMeRestControllerResponse saveActions(@RequestBody Action action) {
		listenMeProcess.saveActions(action);
		return null;
	}

	@PostMapping(path = "/activity")
	public ListenMeRestControllerResponse saveActions(@RequestBody Activity activity) {
		listenMeProcess.saveActivity(activity);
		return null;
	}

	@GetMapping(path = "/action")
	public Set<Action> predictPossibleActions(@RequestParam(name = "q") String input) {
		return listenMeProcess.predictPossibleActions(input);
	}

}
