package com.example.dockerPostgres.dao;

import com.example.dockerPostgres.model.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    //Insert - POST Req
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    //Retrieve - GET Req
    List<Person> selectAllPersons() throws SQLException;

    //Select
    Optional<Person> selectPersonById(UUID id);

    //Delete
    int deletePersonById(UUID id);

    //Update
    int updatePersonById(UUID id, Person person);
}
