package org.stephane.input.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "personne",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonneControler {
    @GetMapping
    public ResponseEntity<String> msg() {
        return new ResponseEntity<>("coucou !!", HttpStatus.OK);
    }
}
