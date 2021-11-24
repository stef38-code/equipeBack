package org.stephane.equipe.output.jpa;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.stephane.equipe.output.entities.Personne;
import org.stephane.*;
@SpringBootTest(classes = ApplicationEquipe.class)
@RequiredArgsConstructor
class PersonneRepositoryTest {
    private final PersonneRepository repository;

    @Test
    void createUnepersonne(){
        Personne personne = new Personne();
        personne.setNom("DYLAN");
        personne.setPrenom("BOB");
        repository.save(personne);
    }
}
