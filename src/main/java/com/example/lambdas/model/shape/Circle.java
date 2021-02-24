package com.example.lambdas.model.shape;

import java.awt.*;

public class Circle {

    private Color color;
    private int x;
    private int y;
    private int radius;

    public Circle() {
        color = Color.WHITE;
    }

    public Circle(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [color= "+color+" "+x+" "+y+" "+radius+"]";
    }
}
