package com.example.lambdas.designpatterns.registry.switchregistry;

import com.example.lambdas.designpatterns.factory.Factory;
import com.example.lambdas.model.shape.Rectangle;

public class PlayWithSwitchRegistry {

    public static void main(String[] args) {

        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        System.out.println("Rectangle: " + rectangleFactory.newInstance());
    }
}
