package com.listenme.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author eknath.take
 *
 */
@Entity
@Table(name = "TACTION")
public class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String voiceCmd;

	@OneToMany(mappedBy = "actions", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
