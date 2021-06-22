package com.example.bobbot.repository;

import com.example.bobbot.entity.Pasta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastaRepository extends CrudRepository<Pasta,Long> {

    Pasta findPastaByPastaText(String pastaText);

}
