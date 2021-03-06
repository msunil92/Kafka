package com.bigdata.kafka;

public interface Config {
	public static final String BOOTSTRAP_SERVERS_CONFIG = "bootstrap.servers";
	public static String KAFKA_BROKERS = "9.199.147.98:9092";
	public static String CLIENT_ID = "client1";
	public static final String KEY_SERIALIZER_CLASS_CONFIG = "key.serializer";
	public static final String VALUE_SERIALIZER_CLASS_CONFIG = "value.serializer";
	public static final String TOPIC_NAME = "sunil";
	public static final Integer MESSAGE_COUNT = 1000;
	public static final String GROUP_ID_CONFIG = "consumerGroup1";
	public static final Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
	public static final String OFFSET_RESET_LATEST = "latest";
	public static final String OFFSET_RESET_EARLIER = "earliest";
	public static final Integer MAX_POLL_RECORDS = 1;
}