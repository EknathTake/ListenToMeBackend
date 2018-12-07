package com.listenme.process.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import com.listenme.domain.entity.Action;
import com.listenme.process.api.ListenMeProcess;
import com.listenme.service.api.ListenMeService;

@Component(value = "listenMeProcess")
public class ListenMeProcessImpl implements ListenMeProcess {

	@Inject
	@Named("listenMeService")
	private ListenMeService listenMeService;

	@Override
	public List<Action> saveActions() {
		listenMeService.saveActions();
		return null;
	}

	@Override
	public Set<Action> predictPossibleActions(String input) {
		// TODO Auto-generated method stub
		return listenMeService.predictPossibleActions(input);
	}

}
