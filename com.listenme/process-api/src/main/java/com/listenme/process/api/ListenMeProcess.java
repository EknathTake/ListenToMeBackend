package com.listenme.process.api;

import java.util.List;
import java.util.Set;

import com.listenme.domain.entity.Action;

public interface ListenMeProcess {

	List<Action> saveActions();

	Set<Action> predictPossibleActions(String input);

}
