package org.stephane.input.adapter;

import org.stephane.input.entities.PersonneDto;
import org.stephane.input.port.PersonnePortInput;

import java.util.List;

public class PersonnePortInputMockAdapter implements PersonnePortInput {
    @Override
    public List<PersonneDto> getPersonnes() {
        return null;
    }

    @Override
    public PersonneDto getPersonneById(String personneId) {
        return null;
    }

    @Override
    public PersonneDto addPersonne(PersonneDto personneDto) {
        return null;
    }

    @Override
    public PersonneDto removePersonne(String personneId) {
        return null;
    }
}
