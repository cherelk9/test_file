package controller;

import entities.Person;
import services.PersonService;

import java.io.IOException;

public class PersonController {

    private static PersonService personService = new PersonService();

    public PersonController(PersonService personService) {
        PersonController.personService = personService;
    }

    public void addPerson(Person person) throws IOException{
        personService.addPerson(person);
    }

    public  void getAllPerson() throws IOException {
        for (var person : personService.getAllPerson())
            System.out.println(person);
    }

    public void findPersonByName(String name) throws IOException{
        for (var names: personService.findPersonByName(name))
            System.out.println(name);
    }

    public void delet(String name) throws IOException{
        personService.remouvePerson(name);
    }

}
