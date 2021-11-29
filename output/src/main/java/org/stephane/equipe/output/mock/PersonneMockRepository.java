package org.stephane.equipe.output.mock;

import org.stephane.equipe.output.entities.Personne;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PersonneMockRepository {
    private static Map<String,Personne> db;

    static{
         db = List.of(0,1,2,3,4,5,6,7,8,9).stream().map(
                element -> new Personne(String.valueOf(element),
                        "Nom_".concat(String.valueOf(element)),
                        "Prenom_".concat(String.valueOf(element)),
                        LocalDate.now().minusYears(element))
        ).collect(Collectors.toMap(element -> element.getId(),element -> element));
    }
    public List<Personne> findAll() {
        return db.values().stream()
                .collect(Collectors.toList());
    }

    public Optional<Personne> findById(String id) {
        Optional<Map.Entry<String, Personne>> first = db.entrySet().stream().filter(e -> e.getKey().equals(id)).findFirst();
        if(first.isPresent()){
            return Optional.ofNullable(first.get().getValue());
        }
        return Optional.empty();
    }

    public void deleteById(String id) {
        db.remove(id);
    }

    public Personne save(Personne personne) {
        UUID uuid = UUID.randomUUID();
        personne.setId(uuid.toString());
        db.put(uuid.toString(),personne);
        return personne;
    }
}
