package com.hebron.onlineshop.utils;

import lombok.Getter;

@Getter
public abstract class TestData {

    private boolean positive;
    private int expectedHttpCode;
    private String expectedErrorMessage;

    public TestData withExpectedHTTPCode(int code) {
        this.expectedHttpCode = code;
        return this;
    }

    public TestData shouldPass(boolean positive) {
        this.positive = positive;
        return this;
    }

    public TestData withExpectedErrorMessage(String errorMessage) {
        this.expectedErrorMessage = errorMessage;
        return this;
    }
}
