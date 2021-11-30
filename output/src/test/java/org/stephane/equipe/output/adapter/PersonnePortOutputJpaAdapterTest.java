package org.stephane.equipe.output.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.stephane.equipe.output.entities.PersonneOutput;
import org.stephane.equipe.output.jpa.PersonneJpaRepository;
import org.stephane.equipe.output.port.PersonnePortOuput;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration(classes = {PersonneJpaRepository.class, PersonnePortOutputJpaAdapter.class})
@ComponentScan(basePackages = {"org.stephane.equipe.output.adapter"})
@EnableJpaRepositories(basePackages = {"org.stephane.equipe.output.jpa"})
@EntityScan({"org.stephane.equipe.output.entities"})
@Sql("/scripts/PersonneOutputJpaAdapter.sql")
class PersonnePortOutputJpaAdapterTest {
    private PersonnePortOuput personnePortOuput;
    @Autowired
    @Qualifier("PersonneJpaRepository")
    private PersonnePortOutputJpaAdapter repository;

    @BeforeEach
    void setUp() {
        personnePortOuput = this.repository;
    }

    @Test

    void findAll() {
        List<PersonneOutput> list = personnePortOuput.findAll();
        assertThat(list).hasSize(6);
    }

    @Test
    void findById() {
        Optional<PersonneOutput> actual = personnePortOuput.findById("2");
        assertThat(actual).isPresent();
        assertThat(actual.get().getId()).isNotBlank();
        actual = personnePortOuput.findById("999999");
        assertThat(actual).isNotPresent();
    }

    @Test
    void deleteById() {
        personnePortOuput.deleteById("1");
        assertThat(personnePortOuput.findAll()).hasSize(5);
    }

    @Test
    void save() {
        PersonneOutput personneOutput = new PersonneOutput();
        personneOutput.setPrenom("Prenom");
        personneOutput.setId("42");
        personneOutput.setNom("Nom");
        personneOutput.setDnaiss(LocalDate.ofEpochDay(1L));
        PersonneOutput actual = personnePortOuput.save(personneOutput);
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotBlank();
    }
}
