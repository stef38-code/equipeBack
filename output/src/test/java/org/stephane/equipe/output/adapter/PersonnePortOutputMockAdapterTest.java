package org.stephane.equipe.output.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.equipe.output.entities.PersonneOutput;
import org.stephane.equipe.output.port.PersonnePortOuput;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PersonnePortOutputMockAdapterTest {
    private PersonnePortOuput personnePortOuput;

    @BeforeEach
    void setUp() {
        personnePortOuput = new PersonnePortOutputMockAdapter();
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
        Optional<PersonneOutput> actual = personnePortOuput.findById("2");
        assertThat(actual).isPresent();
        assertThat(actual.get().getId()).isNotBlank();
        actual = personnePortOuput.findById("999999");
        assertThat(actual).isNotPresent();
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

