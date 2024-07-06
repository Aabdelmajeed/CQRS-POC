package com.common.deposit.repository;

import com.common.deposit.entity.Deposit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepositRepository extends MongoRepository<Deposit, String> {
}
