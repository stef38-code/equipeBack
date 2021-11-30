package org.stephane.equipe.output.mock;

import org.stephane.equipe.output.entities.PersonneOutput;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class PersonneMockRepository {
    private static Map<String, PersonneOutput> db;

    static{
         db = List.of(0,1,2,3,4,5,6,7,8,9).stream().map(
                 element -> new PersonneOutput(String.valueOf(element),
                         "Nom_".concat(String.valueOf(element)),
                         "Prenom_".concat(String.valueOf(element)),
                         LocalDate.now().minusYears(element))
         ).collect(Collectors.toMap(element -> element.getId(), element -> element));
    }

    public List<PersonneOutput> findAll() {
        return db.values().stream()
                .collect(Collectors.toList());
    }

    public Optional<PersonneOutput> findById(String id) {
        Optional<Map.Entry<String, PersonneOutput>> first = db.entrySet().stream().filter(e -> e.getKey().equals(id)).findFirst();
        if (first.isPresent()) {
            return Optional.ofNullable(first.get().getValue());
        }
        return Optional.empty();
    }

    public void deleteById(String id) {
        db.remove(id);
    }

    public PersonneOutput save(PersonneOutput personneOutput) {
        UUID uuid = UUID.randomUUID();
        personneOutput.setId(uuid.toString());
        db.put(uuid.toString(), personneOutput);
        return personneOutput;
    }
}
