package com.listenme.domain.model;

/**
 * 
 * @author eknath.take
 *
 */
public class Action {

	private Long id;

	private String voiceCmd;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Action [id=");
		builder.append(id);
		builder.append(", voiceCmd=");
		builder.append(voiceCmd);
		builder.append("]");
		return builder.toString();
	}

}
