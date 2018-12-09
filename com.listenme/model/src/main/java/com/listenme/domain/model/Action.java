package com.listenme.domain.model;

import java.util.Set;

/**
 * 
 * @author eknath.take
 *
 */
public class Action {

	private Long id;

	private String voiceCmd;

	private Set<Activity> activities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVoiceCmd() {
		return voiceCmd;
	}

	public void setVoiceCmd(String voiceCmd) {
		this.voiceCmd = voiceCmd;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Action [id=");
		builder.append(id);
		builder.append(", voiceCmd=");
		builder.append(voiceCmd);
		builder.append(", activities=");
		builder.append(activities);
		builder.append("]");
		return builder.toString();
	}

}
