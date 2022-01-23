package com.example.dockerPostgres.dao;

import com.example.dockerPostgres.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPersons() throws SQLException {
        final String s = "Select * from person";
        return (List<Person>) jdbcTemplate.query(s, (resultSet,i) ->
        {UUID id1 = UUID.fromString(resultSet.getString("id"));
        String name1 = resultSet.getString("name");
        return new Person(id1,name1);});
        /*return jdbcTemplate.query(s,(resultSet,a)->{
            UUID id1 = UUID.fromString(resultSet.getString("id"));
            String name1 = resultSet.getString("name");
            return new Person(id1,name1);
        });
        // return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));*/
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
