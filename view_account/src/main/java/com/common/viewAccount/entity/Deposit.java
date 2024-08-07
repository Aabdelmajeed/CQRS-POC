package com.common.viewAccount.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accounts-view")
public class Deposit {
    @Id
    private String id;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private double amount;
}