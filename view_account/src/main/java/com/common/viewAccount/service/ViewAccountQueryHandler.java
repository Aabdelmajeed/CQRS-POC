package com.common.viewAccount.service;

import com.common.viewAccount.entity.Deposit;
import com.common.viewAccount.repository.ViewAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewAccountQueryHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewAccountQueryHandler.class);

    private final ViewAccountRepository viewAccountRepository;

    public ViewAccountQueryHandler(ViewAccountRepository viewAccountRepository) {
        this.viewAccountRepository = viewAccountRepository;
    }

    public Deposit handleByAccountNumber(String accountNumber) {
        LOGGER.info("before querying the database, accountNumber: {}", accountNumber);
        return this.viewAccountRepository.findByAccountNumber(accountNumber);
    }

    public List<Deposit> handleAll(){
        return this.viewAccountRepository.findAll();
    }
}
