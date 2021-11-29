package org.stephane.equipe.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.equipe.output.entities.Personne;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, String> {
    List<Personne> findAllById(String id);
}
