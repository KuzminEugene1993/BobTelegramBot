package com.example.bobbot.service;

import com.example.bobbot.entity.Pasta;
import org.springframework.stereotype.Service;

@Service
public interface PastaService {
   void savePasta(Pasta pasta);
}
