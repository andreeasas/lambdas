package com.example.lambdas.designpatterns.registry;

import com.example.lambdas.designpatterns.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);
}
