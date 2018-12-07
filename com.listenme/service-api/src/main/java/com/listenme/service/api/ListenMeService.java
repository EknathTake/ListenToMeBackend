package com.listenme.service.api;

import java.util.Set;

import com.listenme.domain.entity.Action;

public interface ListenMeService {

	void saveActions();

	Set<Action> predictPossibleActions(String input);

}
