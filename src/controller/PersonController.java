package controller;

import entities.Person;
import entities.Sex;
import services.PersonService;

import java.io.IOException;
import java.util.List;

public class PersonController {

    private static PersonService personService = new PersonService();



    public  PersonController(PersonService personService) {
        PersonController.personService = personService;
    }



    public void addPerson(Person person) throws IOException{
        personService.addPerson(person);
    }

    public void addAllPersons(List<Person> personList) throws IOException{
        personService.addAllPerson(personList);
    }

    public  void getAllPerson() throws IOException {
        personService.getAllPerson()
                .forEach(person->System.out.println(person.toString()));
    }

    public void findPersonByName(String name) throws IOException{
        personService
                .findPersonByName(name)
                .forEach(person->System.out.println(person.toString()));

    }

    public void findPersonByAge(int age) throws IOException{
        personService
                .findPersonByAge(age)
                .forEach(p->System.out.println(p.toString()));
    }

    public void findPersonBySex(Sex sex) throws  IOException{
        personService
                .findPersonBySex(sex)
                .forEach(p->System.out.println(p.toString()));
    }

    public void delete(String name) throws IOException{
        personService.removePerson(name);
    }

}
