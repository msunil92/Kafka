package com.bigdata.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;


public class KafkaProd {
	public  void Produce (String data) {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Config.KAFKA_BROKERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, Config.CLIENT_ID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		ProducerRecord<String, String> record = new ProducerRecord<String,String>(Config.TOPIC_NAME, "Data is here : " + data);
		producer.send(record);
//		ProducerRecord<String, String> record = null;
//		for (int i = 0; i < 1000; i++) {
//			record = new ProducerRecord<String, String>(Config.TOPIC_NAME, i + " : " +  data);
//			producer.send(record);
//		}
		producer.close();
	}
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Config.KAFKA_BROKERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, Config.CLIENT_ID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		// ProducerRecord<String, String> record = new ProducerRecord<String,
		// String>(Config.TOPIC_NAME, "sunil is here!!");
		ProducerRecord<String, String> record = null;
		for (int i = 0; i < 1000; i++) {
			record = new ProducerRecord<String, String>(Config.TOPIC_NAME, i + " : Raj is here!!");
			producer.send(record);
		}
		producer.close();
	}
}
