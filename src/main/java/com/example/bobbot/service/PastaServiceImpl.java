package com.example.bobbot.service;


import com.example.bobbot.entity.Pasta;
import com.example.bobbot.repository.PastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PastaServiceImpl implements PastaService {

    private final PastaRepository pastaRepository;

    @Autowired
    public PastaServiceImpl(PastaRepository pastaRepository) {

        this.pastaRepository = pastaRepository;
    }

    @Override
    public void savePasta(Pasta pasta) {
        pastaRepository.save(pasta);
    }

    public String findRandomPasta(){
        List<Pasta> listOfPasta = new ArrayList<>();
        pastaRepository.findAll().forEach(listOfPasta::add);
        int quantityOfPasta = listOfPasta.size();
        int random = new Random().nextInt(quantityOfPasta);
        Pasta randomPasta = listOfPasta.get(random);
        return randomPasta.getPastaText();
    }
}
