package org.example.service;

import org.example.data.DataBase;
import org.example.model.User;

public class RegService {

    public User save(User user) {
        DataBase.userLIst.add(user);
        return user;
    }

}


