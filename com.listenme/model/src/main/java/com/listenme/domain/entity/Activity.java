package com.listenme.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TACTIVITY")
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fieldInput;

	private String userResponse;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "action_id")
	private Action actions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldInput() {
		return fieldInput;
	}

	public void setFieldInput(String fieldInput) {
		this.fieldInput = fieldInput;
	}

	public String getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(String userResponse) {
		this.userResponse = userResponse;
	}

	public Action getActions() {
		return actions;
	}

	public void setActions(Action actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Activity [id=");
		builder.append(id);
		builder.append(", fieldInput=");
		builder.append(fieldInput);
		builder.append(", userResponse=");
		builder.append(userResponse);
		builder.append(", actions=");
		builder.append(actions);
		builder.append("]");
		return builder.toString();
	}

}
