package com.example.lambdas.designpatterns.registry.switchregistry;

import com.example.lambdas.designpatterns.factory.Factory;
import com.example.lambdas.model.shape.Rectangle;
import com.example.lambdas.model.shape.Shape;
import com.example.lambdas.model.shape.Square;
import com.example.lambdas.model.shape.Triangle;

public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape) {

        switch (shape) {
            case "square" : return () -> new Square();
            case "triangle" : return () -> new Triangle();
            case "rectangle" : return () -> new Rectangle();
            default:
                throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }
}
