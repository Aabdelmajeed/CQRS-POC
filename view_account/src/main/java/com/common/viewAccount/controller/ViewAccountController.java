package com.common.viewAccount.controller;

import com.common.viewAccount.entity.Deposit;
import com.common.viewAccount.model.response.ApiResponseModel;
import com.common.viewAccount.service.ViewAccountQueryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewAccountController {
    private final ViewAccountQueryHandler depositQueryHandler;

    public ViewAccountController(ViewAccountQueryHandler depositQueryHandler) {
        this.depositQueryHandler = depositQueryHandler;
    }

    @GetMapping(value = "/deposit/{accountNumber}")
    public ResponseEntity<Deposit> findbyAccountNumber(@PathVariable("accountNumber") String accountNumber){
        return ResponseEntity.ok().body(this.depositQueryHandler.handleByAccountNumber(accountNumber));
    }

    @GetMapping(value = "/deposit")
    public ResponseEntity<List<Deposit>> findAll(){
        return ResponseEntity.ok().body(this.depositQueryHandler.handleAll());
    }
}
