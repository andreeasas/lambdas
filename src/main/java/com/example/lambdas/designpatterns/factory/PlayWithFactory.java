package com.example.lambdas.designpatterns.factory;

import com.example.lambdas.model.shape.Circle;

import java.awt.*;
import java.util.List;

public class PlayWithFactory {

    public static void main(String[] args) {
        Factory<Circle> factory1 = Factory.createFactory(Circle::new, Color.RED);
        Factory<Circle> factory2 = Factory.createFactory(Circle::new);
        Factory<Circle> factory3 = Factory.createFactory(PlayWithFactory::createCircle, Color.BLUE, 10, 10, 100);

        Circle circleType1 = factory1.newInstance();
        System.out.println("Circle of type 1 = " + circleType1);

        List<Circle> circlesType2 = factory2.createMoreInstances(5);
        System.out.println("List of cirles of type 2 = " + circlesType2);

        Circle circleType3 = factory3.newInstance();
        System.out.println("Circle of type 3 = " + circleType3);
    }

    private static Circle createCircle(Color color, Integer x, Integer y, Integer radius) {
        Circle circle = new Circle();
        circle.setColor(color);
        circle.setX(x);
        circle.setY(y);
        circle.setRadius(radius);
        return circle;
    }

}
