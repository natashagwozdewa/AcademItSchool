package ru.academits.gwozdewa.shapes;

/**
 * Created by Наталия on 29.10.2016.
 */
public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public String getName() {
        return "Квадрат";
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
        return "Фигура: " + this.getName() + ", Длина стороны: " + this.getWidth() + ", Площадь: " + this.getArea() + ", Периметр: " + this.getPerimeter();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Square s = (Square) obj;
        return length == s.length;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) length;
        return hash;
    }
}
