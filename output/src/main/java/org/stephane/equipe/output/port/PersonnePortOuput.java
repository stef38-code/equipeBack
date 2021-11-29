package org.stephane.equipe.output.port;

import org.stephane.equipe.output.entities.Personne;

import java.util.List;
import java.util.Optional;

public interface PersonnePortOuput {
    List<Personne> findAll();
    Optional<Personne> findById(String id);
    void deleteById(String id);
    Personne save(Personne personne);
}
