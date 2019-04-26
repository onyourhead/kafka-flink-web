package edu.ncut.kafkaflinkweb.utils;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerSingleton {
	private static KafkaConsumer<String, String> consumer = null;
	
	
	public static KafkaConsumer<String, String> getConsumer(String topic) {
		if (consumer == null) {
			synchronized (KafkaConsumer.class) {
				if (consumer==null) {
					Properties props = KafkaConfig.getConsummerProp();
					consumer = new KafkaConsumer<>(props);
					System.out.println("链接被销毁，重新创建连接。");
				}
			}
		}
		consumer.subscribe(Collections.singletonList(topic));
		return consumer;
	}
}
