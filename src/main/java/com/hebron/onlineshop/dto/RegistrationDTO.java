package com.hebron.onlineshop.dto;

import com.hebron.onlineshop.dto.utils.DataDTO;
import com.hebron.onlineshop.util.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegistrationDTO extends ResponseDTO {

    private String firstName;
    private String secondName;
    private DataDTO birth;
    private Gender gender;
    private String email;
    private String phone;
    private String city;
}
