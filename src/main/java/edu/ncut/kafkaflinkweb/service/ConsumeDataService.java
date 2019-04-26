package edu.ncut.kafkaflinkweb.service;

import edu.ncut.kafkaflinkweb.entity.EchartData1;
import edu.ncut.kafkaflinkweb.utils.KafkaConsumerSingleton;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConsumeDataService {
    public EchartData1 consume() {
        KafkaConsumer<String, String> consumer = KafkaConsumerSingleton.getConsumer("sink1");
        ConsumerRecords<String, String> records = consumer.poll(100);
        List<Long> timestamp = new ArrayList<>();
        List<Double> value = new ArrayList<>();
        for (ConsumerRecord<String, String> record : records) {
            System.out.printf("offset = %d, topic = %s, value = %s%n", record.offset(), record.topic(), record.value());
            timestamp.add(Long.valueOf(record.value().split(",")[0]));
            value.add(Double.valueOf(record.value().split(",")[1]));
        }
        return new EchartData1(timestamp, value);

    }
}
