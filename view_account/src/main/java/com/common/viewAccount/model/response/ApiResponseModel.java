package com.common.viewAccount.model.response;

import lombok.Data;

@Data
public class ApiResponseModel<T> {
    private String status;
    private String result;
    private ErrorResponse error;
    private T data;
}