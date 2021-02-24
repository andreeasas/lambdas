package com.example.lambdas.comparators;

import java.util.Objects;
import java.util.function.Function;

public interface Comparator<T> {

    int compare(T t1, T t2);

    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor){
        Objects.requireNonNull(keyExtractor); // fail fast
        return (t1, t2) -> {
            U u1 = keyExtractor.apply(t1);
            U u2 = keyExtractor.apply(t2);
            return u1.compareTo(u2);
        };
    }

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor); // fail fast
        Comparator<T> other = comparing(keyExtractor);
        return this.thenComparing(other);
    }

    default Comparator<T> thenComparing(Comparator<T> other){
        Objects.requireNonNull(other); // fail fast
        return (T t1, T t2) -> {
            int compare = this.compare(t1, t2);
            if (compare == 0) {
                return other.compare(t1, t2);
            } else {
                return compare;
            }
        };
    }

}
