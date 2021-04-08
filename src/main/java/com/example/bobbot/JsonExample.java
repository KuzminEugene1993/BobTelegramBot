package com.example.bobbot;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JsonExample {
    public static void main(String[] args) throws IOException {

        String URL = "https://www.hearthstonetopdecks.com/guides/hearthstone-battlegrounds-heroes-tier-list-guides/";

        try{
            Document doc = Jsoup.parse(new URL(URL),3000);
            Elements tiers = doc.select("h3");
            Elements heroes = doc.select("h2");
            Element t1 = tiers.get(7);
            Element t2 = tiers.get(8);
            System.out.println(t1.text());
            for (int i = 2; i <= 12; i++) {
                System.out.println(heroes.get(i).text());
            }
            System.out.println(t2.text());

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
