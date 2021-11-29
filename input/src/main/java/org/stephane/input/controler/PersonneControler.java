package org.stephane.input.controler;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.equipe.output.jpa.PersonneJpaRepository;

@RestController
@RequestMapping(
        value = "personne",
        produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class PersonneControler {
    private final PersonneJpaRepository repository;

    @GetMapping
    public ResponseEntity<String> msg() {
        return new ResponseEntity<>("coucou !!", HttpStatus.OK);
    }
}
