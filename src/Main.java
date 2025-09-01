import controller.PersonController;
import entities.Person;
import entities.Sex;
import services.PersonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args)  throws IOException {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("lionel", 12, "lionel@gmail.com",Sex.MALE));
        persons.add(new Person("elembe", 23, "ongouda@gmail", Sex.MALE));
        persons.add(new Person("oceanne", 24, "oceanne@gmail.fr", Sex.FEMALE));
        persons.add(new Person("alice", 42, "alice@gmail.com", Sex.FEMALE));

        Person person = new Person("Bob", 27, "Bob@gmail.com", Sex.MALE);

        PersonController personController = new PersonController(new PersonService());

        System.out.println("ajouter plusieurs personnes");
        personController.addAllPersons(persons);
        System.out.println("ajouter une personne");
        personController.addPerson(person);
        System.out.println("\n afficher les personnes");
        personController.getAllPerson();
        System.out.println("\n search by name");
        personController.findPersonByName("Bob");
        System.out.println("\n search by age");
        personController.findPersonByAge(12);
        System.out.println("\n search by sex");
        personController.findPersonBySex(Sex.FEMALE);
        personController.delete("lionel"); // delete lionel
        System.out.println("\n print de rest of persons");
        personController.getAllPerson();



    }
}