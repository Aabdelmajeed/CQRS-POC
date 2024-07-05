package com.common.viewAccount.controller;

import com.common.viewAccount.model.response.ApiResponseModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relisol2")
public class SecondRelisolController {
    @GetMapping
    @Operation(summary = "Relisol2 dummy controller", description = "relisol2 dummy controller.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Invoked relisol controller 2"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ApiResponseModel<Void>> reliso2DummyAPI(){
        ApiResponseModel<Void> response = new ApiResponseModel<>();
        response.setStatus("success");
        return ResponseEntity.ok(response);
    }
}
