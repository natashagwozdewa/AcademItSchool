package ru.academits.gwozdewa.shapes;

/**
 * Created by Наталия on 29.10.2016.
 */
public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public String getName() {
        return "Треугольник";
    }

    public double getWidth() {
        return findMax(x1, x2, x3) - findMin(x1, x2, x3);
    }

    public double getHeight() {
        return findMax(y1, y2, y3) - findMin(y1, y2, y3);
    }

    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - getFirstSide()) * (semiPerimeter - getSecondSide()) * (semiPerimeter - getThirdSide()));
    }

    public double getPerimeter() {
        return getFirstSide() + getSecondSide() + getThirdSide();
    }

    private double getFirstSide() {
        return findLengthOfSide(x1, y1, x2, y2);
    }

    private double getSecondSide() {
        return findLengthOfSide(x1, y1, x3, y3);
    }

    private double getThirdSide() {
        return findLengthOfSide(x2, y2, x3, y3);
    }

    private static double findMax(double n1, double n2, double n3) {
        return Math.max(Math.max(n1, n2), n3);
    }

    private static double findMin(double n1, double n2, double n3) {
        return Math.min(Math.max(n1, n2), n3);
    }

    private static double findLengthOfSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public String toString() {
        return "Фигура: " + this.getName() + ",\nКоординаты: x1 = " + x1 + " y1 = " + y1 + " x2 = " + x2 +
                " y2 = " + y2 + " x3 = " + x3 + " y3 = " + y3 + ",\nПлощадь: " + this.getArea()
                + ", Периметр: " + this.getPerimeter();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Triangle t = (Triangle) obj;
        return x1 == t.x1 && y1 == t.y1 && x2 == t.x2 && y2 == t.y2 && x3 == t.x3 && y3 == t.y3;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) x1;
        hash = prime * hash + (int) y1;
        hash = prime * hash + (int) x2;
        hash = prime * hash + (int) y2;
        hash = prime * hash + (int) x3;
        hash = prime * hash + (int) y3;
        return hash;
    }
}
