package com.common.deposit.service;

import com.common.deposit.entity.Deposit;
import com.common.deposit.model.DepositCommand;
import com.common.deposit.repository.DepositRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
 import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DepositCommandHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepositCommandHandler.class);
    private final DepositRepository depositRepository;

    @Autowired
    private KafkaTemplate<String, Deposit> kafkaTemplate;
    private final String TOPIC_NAME = "kafka-de";



    public DepositCommandHandler(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
     }

    public Deposit handle(DepositCommand depositCommand) {
        Deposit deposit = mapCommandToEntity(depositCommand);
        deposit = this.depositRepository.save(deposit);
        publishEvent(deposit);
        return deposit;
    }

    private void publishEvent(Deposit deposit) {
        LOGGER.info("Start sending message to topic :: {}", TOPIC_NAME);
        kafkaTemplate.send(TOPIC_NAME, deposit);
        LOGGER.info("Successfully send message!");
    }

    private Deposit mapCommandToEntity(DepositCommand depositCommand) {
        Deposit deposit = new Deposit();
        deposit.setAccountNumber(depositCommand.getAccountNumber());
        deposit.setFirstName(depositCommand.getFirstName());
        deposit.setLastName(depositCommand.getLastName());
        deposit.setAmount(depositCommand.getAmount());
        return deposit;
    }
}
