package org.stephane.input.service;

import org.stephane.input.entities.PersonneDto;

import java.util.List;

public interface PersonneService {
    List<PersonneDto> getPersonnes();

    PersonneDto getPersonneById(String personneId);

    PersonneDto addPersonne(PersonneDto personneDto);

    PersonneDto removePersonne(String personneId);
}
