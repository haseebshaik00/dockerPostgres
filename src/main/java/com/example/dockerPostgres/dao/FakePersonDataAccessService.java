package com.example.dockerPostgres.dao;

import com.example.dockerPostgres.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    //database
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPersons(){
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> p = selectPersonById(id);
        if(p.isEmpty())
            return 0;
        DB.remove(p.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
                    int index = DB.indexOf(p);
                    if(index >=0 ){
                        DB.set(index, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;
                }
        ).orElse(0);
    }
}
