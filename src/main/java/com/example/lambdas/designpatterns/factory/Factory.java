package com.example.lambdas.designpatterns.factory;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default T newInstance(){
        return get();
    }

    default List<T> createMoreInstances(int numberOfInstances) {
        return IntStream.range(0, numberOfInstances)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    }

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <T,P> Factory<T> createFactory(Function<P, T> constructor,
                                          P parameter) {
        return () -> constructor.apply(parameter);
    }

    static <R, T1, T2, T3, T4> Factory<R> createFactory(Function4<R, T1, T2, T3, T4> constructor, T1 arg1, T2 arg2, T3 arg3, T4 arg4) {
        return () -> constructor.apply(arg1, arg2, arg3, arg4);
    }
}
