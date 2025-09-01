package repository;

import entities.Person;
import entities.Sex;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    void addAllPerson(List<Person> personList) throws IOException;
    List<Person> findPersonByAge(int age) throws IOException;
    List <Person> findPersonByName(String name) throws IOException;
    List<Person> findPersonBySex(Sex sex) throws IOException;
    void addPerson(Person person) throws IOException;
    void remouvePerson(String name) throws IOException;
    List<?> getAllPerson() throws IOException ;
}
