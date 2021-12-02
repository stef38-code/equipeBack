package org.stephane.input.adapter;

import org.stephane.equipe.output.port.PersonnePortOuput;
import org.stephane.input.entities.PersonneDto;
import org.stephane.input.port.PersonnePortInput;
import org.stephane.metier.work.PersonneBusiness;

import java.util.List;

public class PersonnePortInputAdapter implements PersonnePortInput {
    private PersonneBusiness personneBusiness;

    public PersonnePortInputAdapter(PersonnePortOuput personnePortOuput) {
        this.personneBusiness = new PersonneBusiness(personnePortOuput);
    }

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
