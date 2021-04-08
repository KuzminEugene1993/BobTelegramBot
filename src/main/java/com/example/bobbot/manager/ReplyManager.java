package com.example.bobbot.manager;

import com.example.bobbot.hadlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Component
public class ReplyManager implements Manager {


    final private Map<String, Handler> handlers;

    @Autowired
    public ReplyManager(Map<String, Handler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public SendMessage manage(Update update) {
        String inputMsg = update.getMessage().getText();
        if ("/start".equals(inputMsg)) {
            return handlers.get("start").handleUpdate(update);
        } else if ("/help".equals(inputMsg)) {
            return handlers.get("help").handleUpdate(update);
        }else if (inputMsg.regionMatches(0,"/addPasta",0,9)){
            return handlers.get("pasta").handleUpdate(update);
        }else if ("/pasta".equals(inputMsg)) {
            return handlers.get("pasta").handleUpdate(update);
        }else if ("/statistic".equals(inputMsg)) {
            return handlers.get("statistic").handleUpdate(update);
        }else {
            return handlers.get("random").handleUpdate(update);
        }
    }
}
