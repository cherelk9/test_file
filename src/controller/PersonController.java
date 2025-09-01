package controller;

import entities.Person;
import entities.Sex;
import services.PersonService;

import java.io.IOException;

public class PersonController {

    private static PersonService personService = new PersonService();


    public  PersonController(PersonService personService) {
        PersonController.personService = personService;
    }



    public void addPerson(Person person) throws IOException{
        personService.addPerson(person);
    }

    public  void getAllPerson() throws IOException {
        personService.getAllPerson().forEach(System.out::println);
    }

    public void findPersonByName(String name) throws IOException{
        personService.findPersonByName(name).forEach(System.out::println);

    }

    public void findPersonByAge(int age) throws IOException{
        personService.findPersonByAge(age).forEach(System.out::println);
    }

    public void findPersonBySex(Sex sex) throws  IOException{
        personService.findPersonBySex(sex).forEach(System.out::println);
    }

    public void delete(String name) throws IOException{
        personService.removePerson(name);
    }

}
