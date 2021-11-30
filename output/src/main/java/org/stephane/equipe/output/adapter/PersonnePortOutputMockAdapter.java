package org.stephane.equipe.output.adapter;

import org.stephane.equipe.output.entities.PersonneOutput;
import org.stephane.equipe.output.mock.PersonneMockRepository;
import org.stephane.equipe.output.port.PersonnePortOuput;

import java.util.List;
import java.util.Optional;

public class PersonnePortOutputMockAdapter implements PersonnePortOuput {
    private PersonneMockRepository repository = new PersonneMockRepository();

    @Override
    public List<PersonneOutput> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PersonneOutput> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public PersonneOutput save(PersonneOutput personneOutput) {
        return repository.save(personneOutput);
    }

}
