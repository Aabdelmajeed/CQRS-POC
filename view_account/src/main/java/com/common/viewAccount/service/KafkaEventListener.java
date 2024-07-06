package com.common.viewAccount.service;

import com.common.viewAccount.entity.Deposit;
import com.common.viewAccount.repository.ViewAccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEventListener.class);

    @Autowired
    private ViewAccountRepository depositRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private final String TOPIC_NAME = "kafka-de";

    @KafkaListener(topics = TOPIC_NAME, groupId = "myGroup")
    public void consumeMessage(String depositMsg){
        try{
            LOGGER.info("Consume message from Kafka topic :: {}, and content is :: {}", TOPIC_NAME, depositMsg);
            Deposit depositEvent = objectMapper.readValue(depositMsg, Deposit.class);

            this.depositRepository.save(depositEvent);
        }catch (IOException ex){
            LOGGER.error("error while parsing message");

        }

    }
}
