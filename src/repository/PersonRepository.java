package repository;

import entities.Person;
import entities.Sex;

import java.io.IOException;
import java.util.List;

public interface PersonRepository {
    void addAllPerson(List<Person> personList) throws IOException;
    List<Person> findPersonByAge(int age) throws IOException;
    List <Person> findPersonByName(String name) throws IOException;
    List<Person> findPersonBySex(Sex sex) throws IOException;
    void addPerson(Person person) throws IOException;
    void removePerson(String name) throws IOException;
    List<Person> getAllPerson() throws IOException ;

}
