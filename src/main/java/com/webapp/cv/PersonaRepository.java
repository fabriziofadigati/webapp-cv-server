package com.webapp.cv;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
    Iterable<Persona> findBycognome(String cognome);

    /*
    @Modifying
    @Query
    ("UPDATE Persona p SET p.nome = :nome, p.cognome = :cognome, p.codicefiscale = :codicefiscale, p.via = :via,  ")
    */

}

