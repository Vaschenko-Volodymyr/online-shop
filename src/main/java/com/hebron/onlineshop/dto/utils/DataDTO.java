package com.hebron.onlineshop.dto.utils;

import com.hebron.onlineshop.util.Day;
import com.hebron.onlineshop.util.Month;
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
