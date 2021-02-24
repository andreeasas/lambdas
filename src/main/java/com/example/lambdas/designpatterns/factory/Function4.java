package com.example.lambdas.designpatterns.factory;

import java.util.function.Function;

@FunctionalInterface
public interface Function4<R, T1, T2, T3, T4> {

    /**
     * Executes the function and return it's result.
     *
     * @param arg1 the first argument
     * @param arg2 the second argument
     * @param arg3 the third argument
     * @param arg4 the fourth argument
     * @return the function execution result
     */
    R apply(T1 arg1, T2 arg2, T3 arg3, T4 arg4);

}