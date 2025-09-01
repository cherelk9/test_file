package services;

import entities.Person;
import entities.Sex;
import repository.PersonRepository;

import java.io.*;
import java.util.List;

public class PersonService implements PersonRepository{


    @Override
    public void addAllPerson(List<Person> personList) throws IOException {
        for (var pers : personList)
            addPerson(pers);
    }

    @Override
    public List<Person> findPersonByAge(int age) throws IOException {
        List<Person> allPerson = getAllPerson();
        return allPerson.stream()
                .filter(p-> p.getAge() == age)
                .toList();
    }

    @Override
    public List<Person> findPersonByName(String name) throws IOException {
        List<Person> allPerson = getAllPerson();
        return allPerson.stream()
                .filter(p->p.getName().equals(name))
                .toList();
    }

    @Override
    public List<Person> findPersonBySex(Sex sex) throws IOException{
        List<Person> allPerson = getAllPerson();
        return allPerson.stream()
                .filter(p->p.getSex().equals(sex))
                .toList();
    }

    @Override
    public void addPerson(Person person) throws IOException {
        try (var ob = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("person.txt")))) {

            Person person1 = new Person(
                    person.getName(),
                    person.getAge(),
                    person.getMail(),
                    person.getSex()
            );

            ob.writeObject(person1);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removePerson(String name) throws IOException{
        List<Person> personFind = findPersonByName(name);
        List<Person> personList= personFind.stream()
                .filter(p->p.getName().equals(name))
                .toList();

        addAllPerson(personList);

    }



    @Override
    public List<Person> getAllPerson() throws IOException{
        try(var ob = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("person.txt")))) {

            Object obj = ob.readObject();

            if (obj instanceof List<?>) {

                @SuppressWarnings("unchecked")
                List<Person> persons =  (List<Person>) obj;
                return persons;
            }
            throw new IOException("fichier non trouvable");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
