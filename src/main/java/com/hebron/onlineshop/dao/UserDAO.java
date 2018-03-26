package com.hebron.onlineshop.dao;

import com.hebron.onlineshop.dao.interfaces.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class UserDAO implements User{

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

    @Override
    public boolean validateUser(String name, String surname) {
        if (name == null && name.equals(""))
            return false;
        if (surname == null && surname.equals(""))
            return false;
        return true;
    }

    @Override
    public boolean validateUser(String name, String surname, String mail, Date birth, int age) {
        return false;
    }
}
