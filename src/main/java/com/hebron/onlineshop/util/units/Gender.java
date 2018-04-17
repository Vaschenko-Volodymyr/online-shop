package com.hebron.onlineshop.util.units;

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
