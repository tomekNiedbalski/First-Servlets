
package pl.sdacademy.model;

import pl.sdacademy.enums.Sex;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String lastName;
    private int bornYear;
    private int phoneNumber;
    private Sex sex;

    public Person() {
    }

    public Person(String name, String lastName, int bornYear, int phoneNumber, Sex sex) {
        this.name = name;
        this.lastName = lastName;
        this.bornYear = bornYear;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBornYear() {
        return bornYear;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Person> createPersonList(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("Zbigniew", "Kossowski", 1986,853159753, Sex.MALE));
        list.add(new Person("Katarzyna", "Kowalska", 1955,256365957, Sex.FEMALE));
        list.add(new Person("Jan", "Nowak", 1996,321564897, Sex.MALE));
        list.add(new Person("Anna", "Lewandowska", 1982,987654321, Sex.FEMALE));
        list.add(new Person("Łukasz", "Marek", 1946,258369741, Sex.MALE));

        return list;
    }
}

