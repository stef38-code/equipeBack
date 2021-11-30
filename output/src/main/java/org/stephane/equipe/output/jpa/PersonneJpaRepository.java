package org.stephane.equipe.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.equipe.output.entities.PersonneOutput;

import java.util.List;

@Repository
public interface PersonneJpaRepository extends JpaRepository<PersonneOutput, String> {
    List<PersonneOutput> findAllById(String id);
}
