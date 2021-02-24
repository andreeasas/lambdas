package com.example.lambdas.designpatterns.registry;

import com.example.lambdas.designpatterns.factory.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Registry<T> {

    Factory<? extends T> buildShapeFactory(String shape);

    static <T> Registry<T> createRegistry(Consumer<Builder<T>> consumer, Function<String, Factory<T>> errorFunction) {

        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder = (label, factory) -> map.put(label,factory);
        consumer.accept(builder);

        return shape -> map.computeIfAbsent(shape, errorFunction);
    }
}
