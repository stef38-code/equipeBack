package org.stephane.equipe.output.port;

import org.stephane.equipe.output.entities.PersonneOutput;

import java.util.List;
import java.util.Optional;

public interface PersonnePortOuput {
    List<PersonneOutput> findAll();

    Optional<PersonneOutput> findById(String id);

    void deleteById(String id);

    PersonneOutput save(PersonneOutput personneOutput);
}
