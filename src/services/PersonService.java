package services;

import entities.Person;
import entities.Sex;
import exceptions.FileNotFoundException;
import repository.PersonRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService implements PersonRepository{

    File  file = new File("pers.txt");



    private  void savePerson(List<Person> persons) throws IOException{
        if (!file.exists())
            return;

        try(var ob = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                )
        )) {
            ob.writeObject(persons);
        }
    }

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
        List<Person> personList = getAllPerson();
        personList.add(person);
        savePerson(personList);
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
      if (!file.exists())
            return new ArrayList<>();

        try(var ob = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)))) {

            Object obj = ob.readObject();

            if (obj instanceof List<?>) {

                @SuppressWarnings("unchecked")
                List<Person> persons =  (List<Person>) obj;
                return persons;
            }else{
                return new ArrayList<>();
            }



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
