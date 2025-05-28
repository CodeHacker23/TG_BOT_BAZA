package org.example;

import org.example.data.DataBase;
import org.example.model.User;
import org.example.service.AnswerService;
import org.example.service.UserService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private UserService userService = new UserService();
    private AnswerService answerService = new AnswerService();

    public Bot(String botToken) {
        super(botToken);
    }


    @Override
    public void onUpdateReceived(Update update) {
        User currentUser;
        if (!(update.hasMessage() && update.getMessage().hasText())) return;

        String text = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();

        currentUser = regOrGetCurrentUser(update, chatId);
        String textResponse = answerService.getWay(currentUser, text);


        SendMessage sendMessage = new SendMessage(String.valueOf(chatId),textResponse);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private User regOrGetCurrentUser(Update update, Long chatId) {
        User currentUser;
        currentUser = userService.getById(chatId);
        if (currentUser == null) {
            User userCreated = userService.createUser(update.getMessage());
            DataBase.userLIst.add(userCreated);
            currentUser = userCreated;
        }
        return currentUser;
    }

    @Override
    public String getBotUsername() {
        return "News_javist_bot";
    }


}
