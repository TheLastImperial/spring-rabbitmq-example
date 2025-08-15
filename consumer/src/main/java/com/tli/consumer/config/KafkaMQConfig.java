package com.tli.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@Profile("kafka")
public class KafkaMQConfig {
  @Value("${spring.kafka.bootstrap-servers}")
  private String kafkaServers;

  @Value("${spring.kafka.consumer.group-id}")
  private String kafkaGroupId;

  @Bean
  public ConsumerFactory<String, Object> kafkaConsumer() {
    Map<String, Object> map = new HashMap<>();
    map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
    map.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGroupId);
    map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

    return new DefaultKafkaConsumerFactory<>(map);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListener() {
    ConcurrentKafkaListenerContainerFactory<String, Object> factory =
      new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(kafkaConsumer());
    return factory;
  }
}
