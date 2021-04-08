package com.example.bobbot.controllers;

import com.example.bobbot.BobBot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Controller
public class BobController {
    private final BobBot bobBot;

    public BobController(BobBot bobBot) {
        this.bobBot = bobBot;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void getUpdate(Update update){
        bobBot.onUpdateReceived(update);
    }
}
