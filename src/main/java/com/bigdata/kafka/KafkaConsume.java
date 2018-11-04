package com.bigdata.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


public class KafkaConsume {
	public static void main (String a[]) {
		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Config.KAFKA_BROKERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, Config.GROUP_ID_CONFIG);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, Config.MAX_POLL_RECORDS);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Config.OFFSET_RESET_EARLIER);

	    KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		//consumer.subscribe(Collections.singletonList(Config.TOPIC_NAME));
		consumer.subscribe(Arrays.asList(Config.TOPIC_NAME));
		try {
	    	 while (true) {
		         ConsumerRecords<String, String> records = consumer.poll(0);
		         for (ConsumerRecord<String, String> record : records)
		         System.out.println(record.value());
		     }
		
	     } catch(Exception e) {
	    	 System.out.println("Exception occured while consuing messages :" +e);
	     }finally {
	    	 consumer.close();
	     }
	}
}
