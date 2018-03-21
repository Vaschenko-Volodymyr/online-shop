package com.hebron.onlineshop.database;

import com.hebron.onlineshop.dao.interfaces.User;
import org.springframework.stereotype.Repository;

@Repository
public interface Database {

    User getUserById(int id);

    // more methods
}
