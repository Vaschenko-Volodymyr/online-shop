package com.hebron.onlineshop.util;

import lombok.Getter;
import lombok.Setter;

public enum Month {

    JANUARY("jan"),
    FEBRUARY("feb"),
    MARCH("mar"),
    APRIL("apr"),
    MAY("may"),
    JUNE("jun"),
    JULY("jul"),
    AUGUST("aug"),
    SEPTEMBER("sep"),
    NOVEMBER("nov"),
    OCTOBER("okt"),
    DECEMBER("dec");

    @Setter
    @Getter
    private String value;

    Month(String value) {
        this.value = value;
    }
}
