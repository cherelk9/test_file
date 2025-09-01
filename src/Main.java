import controller.PersonController;
import entities.Person;
import entities.Sex;
import services.PersonService;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args)  throws IOException {

        Person person = new Person("lionel", 12, "lionel@gmail.com",Sex.MALE);
        PersonController personController = new PersonController(new PersonService());
        personController.addPerson(person);
        personController.getAllPerson();

    }
}