package com.listenme.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.listenme.domain.entity.Action;
import com.listenme.domain.entity.Activity;
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
	public void saveActions() {
		Action a = new Action();
		a.setVoiceCmd("Add Employee");

		Activity fnm = new Activity();
		fnm.setFieldInput("Firstname");
		fnm.setActions(a);

		Activity lnm = new Activity();
		lnm.setFieldInput("Lastname");
		lnm.setActions(a);

		Set<Activity> activities = new HashSet<>();
		activities.add(fnm);
		activities.add(lnm);
		// a.setActivities(activities);

		Action a1 = new Action();
		a1.setVoiceCmd("Add User");

		Activity fnm1 = new Activity();
		fnm1.setFieldInput("Firstname");
		fnm1.setActions(a1);

		Activity lnm1 = new Activity();
		lnm1.setFieldInput("Lastname");
		lnm1.setActions(a1);

		Set<Activity> activities1 = new HashSet<>();
		activities1.add(fnm1);
		activities1.add(lnm1);
		// a1.setActivities(activities1);

		actionRepository.save(a);
		actionRepository.save(a1);

		activityRepository.save(fnm);
		activityRepository.save(lnm);

		activityRepository.save(fnm1);
		activityRepository.save(lnm1);

	}

	@Override
	public Set<Action> predictPossibleActions(String input) {
		return actionRepository.findAllByVoiceCmd(input);
	}

}
