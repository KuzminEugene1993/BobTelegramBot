package com.example.bobbot;

import com.example.bobbot.hadlers.Handler;
import com.example.bobbot.manager.ReplyManager;
import com.example.bobbot.service.PastaServiceImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BobBot extends TelegramLongPollingBot {

    private final ReplyManager replyManager;

    @Autowired
    public BobBot(ReplyManager replyManager) {
        this.replyManager = replyManager;
    }

    @Getter
    @Value("${bot.name}")
    String botUsername;

    @Getter
    @Value("${bot.token}")
    String botToken;


    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(replyManager.manage(update));
        }catch (TelegramApiException e){
            e.printStackTrace();
        }

    }
}
