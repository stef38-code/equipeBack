package org.stephane.equipe.output.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.stephane.equipe.output.entities.PersonneOutput;
import org.stephane.equipe.output.jpa.PersonneJpaRepository;
import org.stephane.equipe.output.port.PersonnePortOuput;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Qualifier("PersonneJpaRepository")
public class PersonnePortOutputJpaAdapter implements PersonnePortOuput {
    private final PersonneJpaRepository repository;

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
