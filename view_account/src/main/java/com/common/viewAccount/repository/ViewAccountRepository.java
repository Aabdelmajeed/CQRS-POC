package com.common.viewAccount.repository;

 import com.common.viewAccount.entity.Deposit;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewAccountRepository extends MongoRepository<Deposit, String> {
    @Query("{'accountNumber': ?0}")
    Deposit findByAccountNumber(String accountNumber);
}
