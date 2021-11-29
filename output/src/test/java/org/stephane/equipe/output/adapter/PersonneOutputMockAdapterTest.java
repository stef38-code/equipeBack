package org.stephane.equipe.output.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.equipe.output.entities.Personne;
import org.stephane.equipe.output.port.PersonnePortOuput;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PersonneOutputMockAdapterTest {
    private PersonnePortOuput personnePortOuput;

    @BeforeEach
    void setUp() {
        personnePortOuput = new PersonneOutputMockAdapter();
    }

    @Test
    void findAll() {
        assertThat(personnePortOuput.findAll()).hasSize(10);
    }

    @Test
    void deleteById() {
        personnePortOuput.deleteById("1");
        assertThat(personnePortOuput.findAll()).hasSize(10);
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

