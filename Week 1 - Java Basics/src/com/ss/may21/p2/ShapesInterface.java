package com.ss.may21.p2;

import java.lang.Math;

class Main {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(2, 3);
        rect.calculateArea();
        rect.display();

        Circle circ = new Circle(5);
        circ.calculateArea();
        circ.display();

        Triangle triang = new Triangle(2, 5);
        triang.calculateArea();
        triang.display();
    } // main
} // Main

interface Shape {
    void calculateArea();
    void display(); // display the result after calculating area
} // Shape

class Rectangle implements Shape {
    private final double LENGTH, WIDTH;
    private double area;

    Rectangle(double length, double width) {
        this.LENGTH = length;
        this.WIDTH = width;
    }

    @Override
    public void calculateArea() {
        // A = l * w
        this.area = this.LENGTH * this.WIDTH;
    } // calculateArea

    @Override
    public void display() {
        System.out.println("Rectangle area: " + this.area);
    }
} // Rectangle

class Circle implements Shape {
    private final double RADIUS;
    private double area;

    public Circle(double radius) {
        this.RADIUS = radius;
    }

    @Override
    public void calculateArea() {
        // A = pi * r^2
        this.area = Math.PI * Math.pow(RADIUS, 2);
    } // calculateArea

    @Override
    public void display() {
        System.out.println("Circle area: " + this.area);
    }
} // Circle

class Triangle implements Shape {
    private final double base, height;
    private double area;

    public Triangle (double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void calculateArea() {
        // A = .5 * b * h
        this.area = .5 * this.base * this.height;
    } // calculateArea

    @Override
    public void display() {
        System.out.println("Triangle area: " + this.area);
    }
} // Triangle


