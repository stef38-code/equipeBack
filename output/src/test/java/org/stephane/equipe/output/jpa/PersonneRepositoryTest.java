package org.stephane.equipe.output.jpa;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.stephane.equipe.output.entities.Personne;

@SpringBootTest
@TestPropertySource(properties = { "spring.config.location=classpath:application.test.yml" })
@RequiredArgsConstructor
class PersonneRepositoryTest {
    private final PersonneJpaRepository repository;

    @Test
    void createUnepersonne(){
        Personne personne = new Personne();
        personne.setNom("DYLAN");
        personne.setPrenom("BOB");
        repository.save(personne);
    }
}
