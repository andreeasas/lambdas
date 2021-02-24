package com.example.lambdas.designpatterns.visitor;

import java.util.function.Function;

public interface VisitorBuilder<R> {

    void register(Class<?> type, Function<Object, R> function);
}
