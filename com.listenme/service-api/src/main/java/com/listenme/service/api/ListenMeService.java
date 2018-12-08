package com.listenme.service.api;

import java.util.Set;

import com.listenme.domain.model.Action;
import com.listenme.domain.model.Activity;

public interface ListenMeService {

	void saveActions(Action action);

	Set<Action> predictPossibleActions(String input);

	void saveActivity(Activity activity);

}
