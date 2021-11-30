package org.stephane.input.port;

import org.stephane.input.entities.PersonneDto;

import java.util.List;

public interface PersonnePortInput {
    List<PersonneDto> getPersonnes();

    PersonneDto getPersonneById(String personneId);

    PersonneDto addPersonne(PersonneDto personneDto);

    PersonneDto removePersonne(String personneId);
}
