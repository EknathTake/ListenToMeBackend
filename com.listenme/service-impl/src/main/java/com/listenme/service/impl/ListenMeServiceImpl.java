package com.listenme.service.impl;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.listenme.domain.model.Action;
import com.listenme.domain.model.Activity;
import com.listenme.repository.ActionRepository;
import com.listenme.repository.ActivityRepository;
import com.listenme.service.api.ListenMeService;

@Service("listenMeService")
public class ListenMeServiceImpl implements ListenMeService {

	@Inject
	@Named("actionRepository")
	private ActionRepository actionRepository;

	@Inject
	@Named("activityRepository")
	private ActivityRepository activityRepository;

	@Override
	public void saveActions(Action action) {
		actionRepository.save(action);
	}

	@Override
	public void saveActivity(Activity activity) {
		activityRepository.save(activity);
	}

	@Override
	public Set<Action> predictPossibleActions(String input) {
		return actionRepository.findAllByVoiceCmd(input);
	}

}
