package com.listenme.service.impl;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		com.listenme.domain.entity.Action actionEntity = new com.listenme.domain.entity.Action();
		actionEntity.setId(action.getId());
		actionEntity.setVoiceCmd(action.getVoiceCmd());
		Set<Activity> activities = action.getActivities();
		Set<com.listenme.domain.entity.Activity> activityEntities = activities.stream().filter(Objects::nonNull)
				.map(domain -> {
					com.listenme.domain.entity.Activity entity = new com.listenme.domain.entity.Activity();
					entity.setFieldInput(domain.getFieldInput());
					entity.setUserResponse(domain.getUserResponse());
					entity.setActions(actionEntity);
					return entity;
				}).collect(Collectors.toSet());
		actionEntity.setActivities(activityEntities);
		actionRepository.save(actionEntity);
	}

	@Override
	public void saveActivity(Activity activityDomain) {
		com.listenme.domain.entity.Activity activityEntity = new com.listenme.domain.entity.Activity();
		activityEntity.setId(activityDomain.getId());
		activityEntity.setFieldInput(activityDomain.getFieldInput());
		activityEntity.setUserResponse(activityDomain.getUserResponse());
		activityRepository.save(activityEntity);
	}

	@Override
	public Set<Action> predictPossibleActions(String input) {

		Set<Action> findAllByVoiceCmd = new HashSet<>();
		String[] inputs = input.split("~!~");
		if (inputs.length > 0) {
			Stream.of(inputs).forEach(x -> {
				Set<Action> findAllByVoiceCmd1 = actionRepository.findAllByVoiceCmd(x).stream().filter(Objects::nonNull)
						.map(entity -> {
							Action domain = new Action();
							domain.setVoiceCmd(entity.getVoiceCmd());
							domain.setId(entity.getId());
							Set<com.listenme.domain.entity.Activity> activityEntities = entity.getActivities();
							Set<Activity> activities = activityEntities.stream().filter(Objects::nonNull).map(act -> {
								Activity act1 = new Activity();
								act1.setFieldInput(act.getFieldInput());
								act1.setId(act.getId());
								act1.setUserResponse(act.getUserResponse());
								return act1;
							}).collect(Collectors.toSet());
							domain.setActivities(activities);
							return domain;
						}).collect(Collectors.toSet());
				findAllByVoiceCmd.addAll(findAllByVoiceCmd1);
			});
		}
		return findAllByVoiceCmd;
	}

	@Override
	public void train() {

		com.listenme.domain.entity.Action action = new com.listenme.domain.entity.Action();
		action.setVoiceCmd("Add Employee");

		com.listenme.domain.entity.Action action1 = new com.listenme.domain.entity.Action();
		action1.setVoiceCmd("Add User");

		Stream.of(action, action1).forEach(a -> actionRepository.save(a));

		com.listenme.domain.entity.Activity activity = new com.listenme.domain.entity.Activity();
		activity.setFieldInput("Enter Firstname");
		activity.setActions(action);

		com.listenme.domain.entity.Activity activity1 = new com.listenme.domain.entity.Activity();
		activity1.setFieldInput("Enter Lastname");
		activity1.setActions(action);

		com.listenme.domain.entity.Activity activity2 = new com.listenme.domain.entity.Activity();
		activity2.setFieldInput("Enter Username");
		activity2.setActions(action1);

		com.listenme.domain.entity.Activity activity3 = new com.listenme.domain.entity.Activity();
		activity3.setFieldInput("Enter Password");
		activity3.setActions(action1);

		Stream.of(activity, activity1, activity2, activity3).forEach(a -> activityRepository.save(a));
	}

}
