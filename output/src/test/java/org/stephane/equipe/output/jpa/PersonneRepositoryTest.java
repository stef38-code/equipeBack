package org.stephane.equipe.output.jpa;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.stephane.equipe.output.entities.Personne;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration(classes = PersonneJpaRepository.class)
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = {"org.stephane.equipe.output.jpa"})
@EntityScan({ "org.stephane.equipe.output.entities" })
class PersonneRepositoryTest {
    @Autowired
    private PersonneJpaRepository repository;

    @Test
    void createUnepersonne(){
        Personne personne = new Personne();
        personne.setNom("DYLAN");
        personne.setPrenom("BOB");
        Personne actual = repository.save(personne);
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotBlank();
    }
}
