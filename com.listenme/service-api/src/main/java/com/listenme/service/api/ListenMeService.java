package com.listenme.service.api;

import java.util.Set;

import com.listenme.domain.entity.Action;
import com.listenme.domain.entity.Activity;

public interface ListenMeService {

	void saveActions(Action action);

	Set<Action> predictPossibleActions(String input);

	void saveActivity(Activity activity);

}
