package org.example.service;

import org.example.data.DataBase;
import org.example.model.BankAccount;
import org.example.model.User;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Random;

public class UserService {

    public User createUser(Message message) {


       User user = new User();
       user.setLogin(message.getFrom().getUserName());
       user.setUserId(message.getFrom().getId());
       user.setBankAccount(new BankAccount(500,user.getUserId() + "-"+ randomNumber()));
       return user;

    }


    public int randomNumber(){
        int max = 999;
        int min = 100;
        Random random = new Random();
        return random.nextInt(max-min)+min;
    }


    public User getById (Long userId){
        for (User user : DataBase.userLIst) {
            if(user.equals(userId)){
                return user;
            }
        }
        return null;
    }
}
