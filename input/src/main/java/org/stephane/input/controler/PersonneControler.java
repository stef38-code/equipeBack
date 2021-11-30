package org.stephane.input.controler;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stephane.input.entities.PersonneDto;
import org.stephane.input.port.PersonnePortInput;

import java.util.List;

@RestController
@RequestMapping(
        value = "personne",
        produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class PersonneControler {
    private final PersonnePortInput personnePortInput;

    @GetMapping
    public ResponseEntity<List<PersonneDto>> getProducts() {
        return new ResponseEntity<>(personnePortInput.getPersonnes(), HttpStatus.OK);
    }

    @GetMapping("/{personneId}")
    public ResponseEntity<PersonneDto> getProductById(@PathVariable String personneId) {
        return new ResponseEntity<>(personnePortInput.getPersonneById(personneId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonneDto> addProduct(@RequestBody PersonneDto personneDto) {
        return new ResponseEntity<>(personnePortInput.addPersonne(personneDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{personneId}")
    public ResponseEntity<PersonneDto> removeProduct(@PathVariable String personneId) {
        return new ResponseEntity<>(personnePortInput.removePersonne(personneId), HttpStatus.OK);
    }
}
