package com.hebron.onlineshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthorizationDTO extends RequestDTO {

    private String login;
    private String password;
}
