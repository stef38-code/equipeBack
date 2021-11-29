package org.stephane.equipe.output.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.stephane.equipe.output.entities.Personne;
import org.stephane.equipe.output.jpa.PersonneJpaRepository;
import org.stephane.equipe.output.port.PersonnePortOuput;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PersonneOutputJpaAdapter implements PersonnePortOuput {
    private final PersonneJpaRepository repository;
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
