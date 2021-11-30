package org.stephane.input.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.stephane.equipe.output.port.PersonnePortOuput;
import org.stephane.input.entities.PersonneDto;
import org.stephane.input.port.PersonnePortInput;

import java.util.List;

@RequiredArgsConstructor
@Component
@Qualifier("PersonnePortInputAdapter")
public class PersonnePortInputAdapter implements PersonnePortInput {
    private final PersonnePortOuput personnePortOuput;

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
