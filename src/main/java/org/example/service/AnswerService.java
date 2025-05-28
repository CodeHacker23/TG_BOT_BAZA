package org.example.service;

import org.example.data.DataBase;
import org.example.enums.StateUser;
import org.example.model.User;

public class AnswerService {


    public String getWay(User user, String request) {
        if (user.getStateUser() == StateUser.TRANSFER_ENTER_NUM_CARD) {
                return "проверьте номер еще раз " + request + " ";
        }


        String answer = "";
        switch (request) {
            case "/users" -> {
                answer =  DataBase.userLIst.toString();
            }
            case "/transfer" -> {
                StateUser stateUser = user.getStateUser();
                if (stateUser == StateUser.NOT) {
                    user.setStateUser(StateUser.TRANSFER_ENTER_NUM_CARD);
                    answer  =  "Введите Card-Num";
                }


            }
            default -> {
                answer =  "error";
            }
        }
        return answer;

    }


    public String startCommand() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/users - список пользователей").append("\n");
        stringBuilder.append("/transfer -  перевод на карту").append("\n");
        stringBuilder.append("/my_profil - профиль").append("\n");
        return stringBuilder.toString();
    }
}
