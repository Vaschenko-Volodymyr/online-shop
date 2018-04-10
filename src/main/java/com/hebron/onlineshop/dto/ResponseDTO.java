package com.hebron.onlineshop.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResponseDTO {

    private String info;
    private int responseCode;
    private String errorMessage;

    public ResponseDTO setInfo(String info) {
        this.info = info;
        return this;
    }

    public ResponseDTO setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public ResponseDTO setResponseCode(int responseCode) {
        this.responseCode = responseCode;
        return this;
    }
}
