package com.hebron.onlineshop.dto.utils;

import com.hebron.onlineshop.util.units.Day;
import com.hebron.onlineshop.util.units.Month;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataDTO {

    private int year;
    private Month month;
    private Day day;
}
