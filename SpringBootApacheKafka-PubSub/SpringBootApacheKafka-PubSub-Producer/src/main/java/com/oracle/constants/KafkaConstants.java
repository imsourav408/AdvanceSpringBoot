package com.oracle.constants;

public enum KafkaConstants {

	SCORE_BROADCAST_TOPIC("score-broadcast-topic");

	private String value;

	KafkaConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
