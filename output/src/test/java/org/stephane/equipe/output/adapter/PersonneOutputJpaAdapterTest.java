package org.stephane.equipe.output.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.stephane.equipe.output.entities.Personne;
import org.stephane.equipe.output.jpa.PersonneJpaRepository;
import org.stephane.equipe.output.port.PersonnePortOuput;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes = {PersonneJpaRepository.class,PersonneOutputJpaAdapter.class})
@ComponentScan(basePackages={"org.stephane.equipe.output.adapter"})
@EnableJpaRepositories(basePackages = {"org.stephane.equipe.output.jpa"})
@EntityScan({ "org.stephane.equipe.output.entities" })
@Sql("/scripts/PersonneOutputJpaAdapter.sql")
class PersonneOutputJpaAdapterTest {
    private PersonnePortOuput personnePortOuput;
    @Autowired
    private PersonneOutputJpaAdapter repository;

    @BeforeEach
    void setUp() {
        personnePortOuput = this.repository;
    }

    @Test

    void findAll() {
        List<Personne> list = personnePortOuput.findAll();
        assertThat(list).hasSize(6);
    }

    @Test
    void findById() {
        Optional<Personne> actual = personnePortOuput.findById("2");
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
        Personne personne = new Personne();
        personne.setPrenom("Prenom");
        personne.setId("42");
        personne.setNom("Nom");
        personne.setDnaiss(LocalDate.ofEpochDay(1L));
        Personne actual = personnePortOuput.save(personne);
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotBlank();
    }
}
