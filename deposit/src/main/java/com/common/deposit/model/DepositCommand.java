package com.common.deposit.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DepositCommand {
    private String accountNumber;
    private String firstName;
    private String lastName;
    private double amount;
}