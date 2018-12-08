package com.listenme.process.api;

import java.util.List;
import java.util.Set;

import com.listenme.domain.model.Action;
import com.listenme.domain.model.Activity;

public interface ListenMeProcess {

	List<Action> saveActions(Action action);

	Set<Action> predictPossibleActions(String input);

	List<Action> saveActivity(Activity activity);

}
