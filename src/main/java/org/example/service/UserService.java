package org.example.service;

import org.example.model.BankAccount;
import org.example.model.User;
import org.telegram.telegrambots.meta.api.objects.Message;

public class UserService {

    public User createUser(Message message) {
       User user = new User();
       user.setLogin(message.getFrom().getUserName());
       user.setUserId(message.getFrom().getId());
       user.setBankAccount(new BankAccount());
       return user;

    }
}
