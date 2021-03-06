package ru.academits.gwozdewa.shapes;

/**
 * Created by Наталия on 29.10.2016.
 */
public class Circle implements Shape {
    private double radius;
    private double diameter;

    public Circle(double radius) {
        this.radius = radius;
        diameter = radius * 2;
    }

    public String getName() {
        return "Окружность";
    }

    public double getWidth() {
        return diameter;
    }

    public double getHeight() {
        return diameter;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * diameter;
    }

    public String toString() {
        return "Фигура: " + this.getName() + ", Радиус: " + radius + ", Площадь: " + this.getArea() + ", Периметр: " + this.getPerimeter();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Circle c = (Circle) obj;
        return radius == c.radius;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) radius;
        return hash;
    }
}
