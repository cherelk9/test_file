package entities;

import java.io.Serializable;

public class Person implements Serializable {

    private final String name ;
    private final int age;
    private final String mail;
    private final Sex sex;


    public Person(String name , int age , String mail, Sex sex) {
        this.name = name ;
        this.age = age;
        this.mail = mail;
        this.sex = sex;
    }

    public String getName() {return name;}
    public Sex getSex() {return sex;}
    public String getMail() {return mail;}
    public int getAge() {return age;}
}


