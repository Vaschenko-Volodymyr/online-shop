package com.hebron.onlineshop.util;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Gender {

    MALE("male"),
    FEMALE("female");

    @Setter
    @Getter
    private String value;

    Gender(String value) {
        this.value = value;
    }
}
