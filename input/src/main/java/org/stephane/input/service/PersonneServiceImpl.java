package org.stephane.input.service;

import lombok.RequiredArgsConstructor;
import org.stephane.input.entities.PersonneDto;
import org.stephane.input.port.PersonnePortInput;

import java.util.List;

@RequiredArgsConstructor
public class PersonneServiceImpl implements PersonneService {
    private final PersonnePortInput personnePortInput;

    @Override
    public List<PersonneDto> getPersonnes() {
        return personnePortInput.getPersonnes();
    }

    @Override
    public PersonneDto getPersonneById(String personneId) {
        return personnePortInput.getPersonneById(personneId);
    }

    @Override
    public PersonneDto addPersonne(PersonneDto personneDto) {
        return personnePortInput.addPersonne(personneDto);
    }

    @Override
    public PersonneDto removePersonne(String personneId) {
        return personnePortInput.removePersonne(personneId);
    }
}
