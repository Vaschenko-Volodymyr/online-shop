package com.hebron.onlineshop.util.units;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Day {

    MONDAY("mon"),
    TUESDAY("tue"),
    WEDNESDAY("wed"),
    THURSDAY("thu"),
    FRIDAY("fri"),
    SATURDAY("sat"),
    SUNDAY("sun");

    @Setter
    @Getter
    private String value;

    Day(String value) {
        this.value = value;
    }
}
