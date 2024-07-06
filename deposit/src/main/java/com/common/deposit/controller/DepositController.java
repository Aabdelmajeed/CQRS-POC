package com.common.deposit.controller;

import com.common.deposit.model.DepositCommand;
import com.common.deposit.model.response.ApiResponseModel;
import com.common.deposit.service.DepositCommandHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    private final DepositCommandHandler depositCommandHandler;

    public DepositController(DepositCommandHandler depositCommandHandler) {
        this.depositCommandHandler = depositCommandHandler;
    }

    @PostMapping
    @Operation(summary = "deposit controller", description = "deposit controller.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Invoked relisol controller 1"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ApiResponseModel<Void>> deposit(@RequestBody DepositCommand depositCommand){
        ApiResponseModel<Void> response = new ApiResponseModel<>();
        depositCommandHandler.handle(depositCommand);
        response.setStatus("success");
        return ResponseEntity.ok(response);
    }
}
