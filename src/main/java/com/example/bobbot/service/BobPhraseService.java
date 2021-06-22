package com.example.bobbot.service;

import com.example.bobbot.entity.BobPhrase;

public interface BobPhraseService {
    BobPhrase getBobPhrasesByTag(String tag);
    String findRandomPhrase();
}
