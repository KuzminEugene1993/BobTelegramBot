package com.example.bobbot.hadlers;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.net.URL;

@Component("statistic")
public class StatisticHandler implements Handler {
    String URL = "https://www.hearthstonetopdecks.com/" +
            "guides/hearthstone-battlegrounds-heroes-tier-list-guides/";

    @Override
    public SendMessage handleUpdate(Update update) {
        if (update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            return new SendMessage(String.valueOf(chat_id), getInfoFromURL());
        }
        return null;
    }

    public String getInfoFromURL(){
        try{
            String resultInfo = null;
            StringBuilder builder = new StringBuilder();
            Document doc = Jsoup.parse(new URL(URL),3000);
            Elements tiers = doc.select("h3");
            Elements heroes = doc.select("h2");
            Element t1 = tiers.get(7);
            Element t2 = tiers.get(8);
            builder.append(t1.text());
            for (int i = 2; i <= 12; i++) {
                builder.append("\n").append(heroes.get(i).text());
            }
            resultInfo = new String(builder);
            return resultInfo;

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
