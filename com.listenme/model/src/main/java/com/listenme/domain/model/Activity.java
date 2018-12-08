package com.listenme.domain.model;

public class Activity {

	private Long id;

	private String fieldInput;

	private String userResponse;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Activity [id=");
		builder.append(id);
		builder.append(", fieldInput=");
		builder.append(fieldInput);
		builder.append(", userResponse=");
		builder.append(userResponse);
		builder.append("]");
		return builder.toString();
	}

}
