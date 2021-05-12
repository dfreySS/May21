package com.ss.may21;

import java.lang.Math;

public class Assignment3 {

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
} // Assignment 3

interface Shape {
    public void calculateArea();
    public void display(); // display the result after calculating area
} // Shape

class Rectangle implements Shape {
    private double length, width, area;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        // A = l * w
        this.area = this.length * this.width;
    }

    @Override
    public void display() {
        System.out.println("Rectangle area: " + this.area);
    }
} // Rectangle

class Circle implements Shape {
    private double radius, area;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        // A = pi * r^2
        this.area = Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Circle area: " + this.area);
    }
} // Circle

class Triangle implements Shape {
    private double base, height, area;

    public Triangle (double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void calculateArea() {
        // A = .5 * b * h
        this.area = .5 * this.base * this.height;
    }

    @Override
    public void display() {
        System.out.println("Triangle area: " + this.area);
    }
} // Triangle


