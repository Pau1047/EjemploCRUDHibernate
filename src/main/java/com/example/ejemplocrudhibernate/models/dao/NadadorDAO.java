package com.example.ejemplocrudhibernate.models.dao;

import com.example.ejemplocrudhibernate.models.entity.Nadador;
import jakarta.persistence.Id;

import java.util.List;

public interface NadadorDAO {
    void save(Nadador nadador);

    void delete(int id);
    void update(Nadador nadador);
    Nadador findbyid(int id);

    List<Nadador> findAll();

    List<Nadador> findByEmail(String email);

    void deleteAll();

}
