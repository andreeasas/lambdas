package com.example.lambdas.designpatterns.validator;

import com.example.lambdas.model.Person;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator {

    // composition
    ValidatorSupplier on (Person person);

    // chaining
    default Validator thenValidate(Predicate<Person> predicate, String errorMessage) {
        return person -> {

            try {
                this.on(person).validate();
                if (predicate.test(person)) {
                    return () -> person;
                } else {
                    return () -> {
                        throw createFirstException(errorMessage);
                    };
                }
            } catch (ValidationException validationException) {
                if (predicate.test(person)) {
                    return () -> { throw validationException;};
                } else {
                    validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                    return () -> { throw validationException;};
                }
            }

        };
    }

    static Validator validate(Predicate<Person> predicate, String errorMessage) {
        return person -> {
            if (predicate.test(person)) {
                return () -> person;
            } else {
                return () -> {
                    throw createFirstException(errorMessage);
                };
            }
        };
    }

    static ValidationException createFirstException(String errorMessage) {
        ValidationException exception = new ValidationException("The object is not valid");
        exception.addSuppressed(new IllegalArgumentException(errorMessage));
        return exception;
    }

    interface ValidatorSupplier extends Supplier<Person> {
        default Person validate() {
            return get();
        }
    }

    static class ValidationException extends RuntimeException {
        public ValidationException(String errorMessage) {
            super(errorMessage);
        }
    }
}
