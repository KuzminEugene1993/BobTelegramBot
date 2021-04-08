package com.example.bobbot.hadlers;

import com.example.bobbot.entity.Pasta;
import com.example.bobbot.service.PastaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("pasta")
public class PastaHandler  implements Handler{

    final
    PastaServiceImpl pastaService;

    @Autowired
    public PastaHandler(PastaServiceImpl pastaService) {
        this.pastaService = pastaService;
    }

    @Override
    public SendMessage handleUpdate(Update update) {
        long chat_id = update.getMessage().getChatId();
        if (update.getMessage().getText().equals("/addPasta")) {
            return new SendMessage(String.valueOf(chat_id), "Введи пасту!");
        } else if (update.getMessage().getText().equals("/pasta")) {
            return new SendMessage(String.valueOf(chat_id),pastaService.findRandomPasta());
        } else {
            int lengthOfCommand = 9;
            String pasta = update.getMessage().getText().substring(lengthOfCommand + 1);
            pastaService.savePasta(new Pasta(pasta));
            return new SendMessage(String.valueOf(chat_id), "Сюда паста!");
        }
    }
}
