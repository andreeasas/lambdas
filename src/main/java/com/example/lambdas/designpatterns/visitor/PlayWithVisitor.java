package com.example.lambdas.designpatterns.visitor;

import com.example.lambdas.model.car.Body;
import com.example.lambdas.model.car.Car;
import com.example.lambdas.model.car.Engine;
import com.example.lambdas.model.car.Wheel;

import java.util.function.Consumer;


public class PlayWithVisitor {

    public static void main(String[] args) {
        Car car = new Car();
        Wheel wheel = new Wheel();
        Engine engine = new Engine();
        Body body = new Body();

        // add behaviour to classes from outside using lambdas
        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<String>forType(Car.class).execute(c -> "Visiting car: " + c)
                        .forType(Wheel.class).execute(w -> "Visiting wheel: " + w)
                        .forType(Engine.class).execute(e -> "Visiting engine: " + e)
                        .forType(Body.class).execute(b -> "Visiting body: " + b);

        Visitor<String> visitor = Visitor.of(consumer);

        String visitedCar = visitor.visit(car);
        System.out.println("Car: " + visitedCar);
        String visitedWheel = visitor.visit(wheel);
        System.out.println("Wheel: " + visitedWheel);
        String visitedEngine = visitor.visit(engine);
        System.out.println("Engine: " + visitedEngine);
        String visitedBody = visitor.visit(body);
        System.out.println("Body: " + visitedBody);
    }
}
