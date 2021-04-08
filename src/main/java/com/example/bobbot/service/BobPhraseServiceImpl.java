package com.example.bobbot.service;


import com.example.bobbot.entity.BobPhrase;
import com.example.bobbot.repository.BobPhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BobPhraseServiceImpl implements BobPhraseService{

    private final BobPhraseRepository bobPhraseRepository;

    @Autowired
    public BobPhraseServiceImpl(BobPhraseRepository bobPhraseRepository) {
        this.bobPhraseRepository = bobPhraseRepository;
    }


    @Override
    public String getBobPhrasesByTag(String tag) {
        return bobPhraseRepository.findBobPhraseByTag(tag).getPhrase();
    }

    public String findRandomPhrase(){
        List<BobPhrase> listOfPhrases = new ArrayList<>();
        bobPhraseRepository.findAll().forEach(listOfPhrases::add);
        int sizeOfPhrase = listOfPhrases.size();
        int random = new Random().nextInt(sizeOfPhrase);
        BobPhrase randomPhrase = listOfPhrases.get(random);
        return randomPhrase.getPhrase();
    }
}
