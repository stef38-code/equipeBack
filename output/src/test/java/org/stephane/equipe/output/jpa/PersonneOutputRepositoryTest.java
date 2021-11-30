package org.stephane.equipe.output.jpa;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.stephane.equipe.output.entities.PersonneOutput;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration(classes = PersonneJpaRepository.class)
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = {"org.stephane.equipe.output.jpa"})
@EntityScan({"org.stephane.equipe.output.entities"})
class PersonneOutputRepositoryTest {
    @Autowired
    private PersonneJpaRepository repository;

    @Test
    void createUnepersonne() {
        PersonneOutput personneOutput = new PersonneOutput();
        personneOutput.setNom("DYLAN");
        personneOutput.setPrenom("BOB");
        PersonneOutput actual = repository.save(personneOutput);
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotBlank();
    }
}
