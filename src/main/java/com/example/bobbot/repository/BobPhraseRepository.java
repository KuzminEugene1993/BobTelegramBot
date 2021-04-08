package com.example.bobbot.repository;

import com.example.bobbot.entity.BobPhrase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BobPhraseRepository extends CrudRepository<BobPhrase, Long> {
    BobPhrase findBobPhraseByTag(String tag);
}