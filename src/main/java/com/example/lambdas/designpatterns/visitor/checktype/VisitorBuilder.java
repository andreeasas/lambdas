package com.example.lambdas.designpatterns.visitor.checktype;

import java.util.function.Function;

public interface VisitorBuilder<R> {

    <T> void register(Class<T> type, Function<T, R> function);
}
