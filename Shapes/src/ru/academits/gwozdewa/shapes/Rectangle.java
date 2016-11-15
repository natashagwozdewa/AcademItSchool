package ru.academits.gwozdewa.shapes;

/**
 * Created by Наталия on 29.10.2016.
 */
public class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public String getName() {
        return "Прямоугольник";
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return length;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return (length + width) * 2;
    }

    public String toString() {
        return "Фигура: " +  this.getName() + ", Ширина: " + this.getWidth() + ", Высота : " + this.getHeight() +", Площадь: " + this.getArea() + ", Периметр: " + this.getPerimeter();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Rectangle r = (Rectangle) obj;
        return length == r.length && width == r.width;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) length;
        hash = prime * hash + (int) width;
        return hash;
    }
}
