package com.example.lambdas.chaining;

import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Examples of using default methods to combine lambdas.
 * */
public class ChainingExamples {

    public static void main(String[] args) {
        playWithConsumers();

        playWithPredicates();
    }

    private static void playWithConsumers() {
        Consumer c1 = s -> System.out.println("c1 = " + s);
        Consumer c2 = s -> System.out.println("c2 = " + s);

        Consumer c3 = c1.andThen(c2);
        c3.accept("Hello");
    }

    private static void playWithPredicates() {
        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> s.isEmpty();

        Predicate<String> p3 = p1.and(p2.negate());

        System.out.println("Test if not null: " + p1.test(null));
        System.out.println("Test if empty: " + p2.test(""));
        System.out.println("Test if not null and not empty: " + p3.test("Hello"));
    }
}
