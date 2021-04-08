package com.example.bobbot.hadlers;

import com.example.bobbot.service.BobPhraseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("random")
public class RandomPhraseHandler implements Handler{


    private final BobPhraseServiceImpl bobPhraseService;

    @Autowired
    public RandomPhraseHandler(BobPhraseServiceImpl bobPhraseService) {
        this.bobPhraseService = bobPhraseService;
    }


    @Override
    public SendMessage handleUpdate(Update update) {
        if (update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            return new SendMessage(String.valueOf(chat_id), bobPhraseService.findRandomPhrase());
        }
        return null;
    }
}
