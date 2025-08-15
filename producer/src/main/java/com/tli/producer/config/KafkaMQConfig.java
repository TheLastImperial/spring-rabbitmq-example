package com.tli.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@Profile("kafka")
public class KafkaMQConfig {
  @Value("${spring.kafka.bootstrap-servers}")
  private String kafkaServers;

  @Bean
  public ProducerFactory<String, Object> kafkaProducer() {
    Map<String, Object> map = new HashMap<>();
    map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
    map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

    return new DefaultKafkaProducerFactory<>(map);
  }

  @Bean
  public KafkaTemplate<String, Object> kafkaTemplate() {
    KafkaTemplate<String, Object> template = new KafkaTemplate<String, Object>(kafkaProducer());
    return template;
  }
}
