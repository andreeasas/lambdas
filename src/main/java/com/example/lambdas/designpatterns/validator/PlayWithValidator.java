package com.example.lambdas.designpatterns.validator;

import com.example.lambdas.model.Person;

public class PlayWithValidator {

    public static void main(String[] args) {
        Person sarah = new Person("Sarah", 30);
        Person james = new Person(null, 30);
        Person mary = new Person("Mary", -10);
        Person john = new Person("John", 1_000);
        Person linda = new Person(null, 1_000);

        sarah = validatePerson(sarah);
        System.out.println("Sarah: " + sarah);

        linda = validatePerson(linda);
        System.out.println("Linda: " + linda);
    }

    private static Person validatePerson(Person person) {
        person =
                Validator.validate(p -> p.getName() != null, "The name should not be null")
                        .thenValidate(p -> p.getAge() > 0, "The age should be greater than 0")
                        .thenValidate(p -> p.getAge() < 150, "The age should be less than 150")
                        .on(person)
                        .validate();
        return person;
    }
}
