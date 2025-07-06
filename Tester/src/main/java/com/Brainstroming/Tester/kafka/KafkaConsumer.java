//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.kafka;

import com.Brainstroming.Tester.Functions.TestCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.Semaphore;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final int MAX_CONCURRENT_TASKS = 6;
    private final Semaphore semaphore = new Semaphore(6);
    private int columnNumber = 0;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TestCode testCode;

    public KafkaConsumer() {
    }

    @KafkaListener(
            topics = {"submissionsqueue"},
            groupId = "Testers"
    )
    public void consume(ConsumerRecord<String, Object> submission) throws JsonProcessingException {
        try {
            this.semaphore.acquire();
            (new Thread(() -> {
                try {
                    String jsonString = this.objectMapper.writeValueAsString(submission.value());
                    KafkaDto kafkaDto = (KafkaDto)this.objectMapper.readValue(jsonString, KafkaDto.class);
                    ++this.columnNumber;
                    String filename = this.getColumnLetter(this.columnNumber);
                    this.testCode.testCode(kafkaDto, filename);
                    this.testCode.deleteFile(filename);
                } catch (Exception var8) {
                    Exception e = var8;
                    e.printStackTrace();
                } finally {
                    this.semaphore.release();
                }

            })).start();
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

    }

    public String getColumnLetter(int columnNumber) {
        StringBuilder columnName;
        int remainder;
        for(columnName = new StringBuilder(); columnNumber > 0; columnNumber = (columnNumber - remainder) / 26) {
            remainder = (columnNumber - 1) % 26;
            columnName.insert(0, (char)(remainder + 65));
        }

        return columnName.toString();
    }
}
