package com.listenme.process.api;

import java.util.Set;

import com.listenme.domain.model.Action;
import com.listenme.domain.model.Activity;

public interface ListenMeProcess {

	void saveActions(Action action);

	Set<Action> predictPossibleActions(String input);

	void saveActivity(Activity activity);

	void train();

}
