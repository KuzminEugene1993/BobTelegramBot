package com.example.bobbot.hadlers;
import com.example.bobbot.service.BobPhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component("start")
public class StartHandler implements Handler{

    private final BobPhraseService bobPhraseService;

    @Autowired
    public StartHandler(BobPhraseService bobPhraseService) {
        this.bobPhraseService = bobPhraseService;
    }

    @Override
    public SendMessage handleUpdate(Update update){
        if (update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            return new SendMessage(
                    String.valueOf(chat_id),
                    bobPhraseService.getBobPhrasesByTag("start").getPhrase());

        }
        return null;
    }
}
