package com.listenme.process.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import com.listenme.domain.model.Action;
import com.listenme.domain.model.Activity;
import com.listenme.process.api.ListenMeProcess;
import com.listenme.service.api.ListenMeService;

@Component(value = "listenMeProcess")
public class ListenMeProcessImpl implements ListenMeProcess {

	@Inject
	@Named("listenMeService")
	private ListenMeService listenMeService;

	@Override
	public List<Action> saveActions(Action action) {
		listenMeService.saveActions(action);
		return null;
	}

	@Override
	public List<Action> saveActivity(Activity activity) {
		listenMeService.saveActivity(activity);
		return null;
	}

	@Override
	public Set<Action> predictPossibleActions(String input) {
		return listenMeService.predictPossibleActions(input);
	}

}
