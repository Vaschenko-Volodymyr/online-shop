package com.hebron.onlineshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class AuthorizationDTO extends ResponseDTO implements Serializable{

    private String login;
    private String password;
}
