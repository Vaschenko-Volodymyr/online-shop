package com.hebron.onlineshop.data.dao.interfaces;

import java.util.Date;

public interface User {
    boolean validateUser(String name, String surname);
    boolean validateUser(String name, String surname, String mail, Date birth, int age);
}
