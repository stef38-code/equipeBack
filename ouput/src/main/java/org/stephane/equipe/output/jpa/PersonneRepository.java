package org.stephane.equipe.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.equipe.output.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, String> {
}
