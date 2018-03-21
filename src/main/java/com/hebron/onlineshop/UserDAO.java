package com.hebron.onlineshop;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class UserDAO {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String surname;

    @Getter
    @Setter
    private String mail;

    @Getter
    @Setter
    private Date birth;

    @Getter
    @Setter
    private int age;

    public UserDAO(String name, String surname, String mail, Date birth, int age) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.birth = birth;
        this.age = age;
    }
}
