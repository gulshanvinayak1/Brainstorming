//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public KafkaTopicConfig() {
    }

    @Bean
    public NewTopic submissionsTopic() {
        return TopicBuilder.name("submissionsqueue").partitions(5).build();
    }
}
