package ru.academits.gwozdewa.shapes;

/**
 * Created by Наталия on 29.10.2016.
 */
public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double getWidth() {
        return this.length;
    }

    public double getHeight() {
        return this.length;
    }

    public double getArea() {
        return Math.pow(length, 2);
    }

    public double getPerimeter() {
        return length * 4;
    }

    public String toString() {
        return "Квадрат";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Square)) {
            return false;
        }
        Square s = (Square) obj;
        return (obj == this) || (length == s.length);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) length;
        return hash;
    }
}
