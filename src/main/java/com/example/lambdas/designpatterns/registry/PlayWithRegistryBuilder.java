package com.example.lambdas.designpatterns.registry;

import com.example.lambdas.designpatterns.factory.Factory;
import com.example.lambdas.model.shape.Rectangle;
import com.example.lambdas.model.shape.Shape;
import com.example.lambdas.model.shape.Square;
import com.example.lambdas.model.shape.Triangle;

import java.util.function.Consumer;

import static com.example.lambdas.designpatterns.registry.Registry.createRegistry;

public class PlayWithRegistryBuilder {

    public static void main(String[] args) {

        Consumer<Builder<Shape>> consumer1 = builder -> builder.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> consumer2 = builder -> builder.register("triangle", Triangle::new);

        Consumer<Builder<Shape>> initializer = consumer1.andThen(consumer2);
        Registry<Shape> registry = createRegistry(initializer, s -> {throw new IllegalArgumentException("Unknown shape: " + s);});

        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        Rectangle rectangle = rectangleFactory.newInstance();
        System.out.println(rectangle);

        Factory<Triangle> triangleFactory = (Factory<Triangle>) registry.buildShapeFactory("triangle");
        Triangle triangle = triangleFactory.newInstance();
        System.out.println(triangle);

        Factory<Square> squareFactory = (Factory<Square>) registry.buildShapeFactory("square");
        Square square = squareFactory.newInstance();
        System.out.println(square);
    }

}
