package com.example.dockerPostgres.api;

import com.example.dockerPostgres.model.Person;
import com.example.dockerPostgres.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@NonNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() throws SQLException {
        return personService.getAllPersons();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id,@NonNull @RequestBody Person p){
        personService.updatePersonById(id, p);
    }
}
