package com.hebron.onlineshop.dto;

import lombok.Getter;

@Getter
public class ErrorDTO {

    private String errorMessage;

    public ErrorDTO setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
