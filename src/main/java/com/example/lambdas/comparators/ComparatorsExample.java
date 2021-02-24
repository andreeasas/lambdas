package com.example.lambdas.comparators;

import com.example.lambdas.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorsExample {

    public static void main(String[] args) {

        ArrayList<Person> people = getDefaultListOfPeople();

        Comparator<Person> personComparator = Comparator
                .comparing(Person::getName)
                .thenComparingInt(Person::getAge);  // use compareInt to avoid auto boxing and unboxing

        people.sort(personComparator);
        System.out.println("order list of people: " + people);
    }

    private static ArrayList<Person> getDefaultListOfPeople() {
        Person maryA = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person maryB = new Person("Mary", 26);
        Person james = new Person("James", 32);

        ArrayList<Person> people = new ArrayList<>(List.of(maryA,john, maryB, james));
        return people;
    }

}
