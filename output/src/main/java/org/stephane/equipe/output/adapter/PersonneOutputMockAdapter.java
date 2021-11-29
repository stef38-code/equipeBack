package org.stephane.equipe.output.adapter;

import org.stephane.equipe.output.entities.Personne;
import org.stephane.equipe.output.mock.PersonneMockRepository;
import org.stephane.equipe.output.port.PersonnePortOuput;

import java.util.List;
import java.util.Optional;

public class PersonneOutputMockAdapter implements PersonnePortOuput {
    private PersonneMockRepository repository = new PersonneMockRepository();

    @Override
    public List<Personne> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Personne> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Personne save(Personne personne) {
        return repository.save(personne);
    }

}
