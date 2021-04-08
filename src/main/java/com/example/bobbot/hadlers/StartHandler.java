package com.example.bobbot.hadlers;
import com.example.bobbot.service.BobPhraseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component("start")
public class StartHandler implements Handler{

    private final BobPhraseServiceImpl bobPhraseServiceImpl;

    @Autowired
    public StartHandler(BobPhraseServiceImpl bobPhraseServiceImpl) {
        this.bobPhraseServiceImpl = bobPhraseServiceImpl;
    }

    @Override
    public SendMessage handleUpdate(Update update){
        if (update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            return new SendMessage(String.valueOf(chat_id), bobPhraseServiceImpl.getBobPhrasesByTag("start"));
        }
        return null;
    }
}
