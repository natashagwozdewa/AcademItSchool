package ru.academits.gwozdewa.shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapesArrayList = new ArrayList<Shape>();
        shapesArrayList.add(new Square(2));
        shapesArrayList.add(new Square(4));
        shapesArrayList.add(new Triangle(1, 2, 3, 1, 2, 5));
        shapesArrayList.add(new Rectangle(2, 3));
        //  shapesArrayList.add(new Circle(3));
      /* for(Shape x: shapesArrayList)
        {
            System.out.println(x.getArea());
        }
        for(Shape x: shapesArrayList)
        {
            System.out.println(x.getPerimeter());
        }*/
        findMaxArea(shapesArrayList);
        findSecondValuePerimeter(shapesArrayList);
    }

    private static void findMaxArea(ArrayList<Shape> shapesList) {
        double maxArea = shapesList.get(0).getArea();
        int counter = 0;
        int index = 0;
        for (Shape x : shapesList) {
            if (x.getArea() > maxArea) {
                maxArea = x.getArea();
                index = counter;
            }
            counter++;
        }
        Shape shape = shapesList.get(index);
        System.out.printf("Максимальная площадь: %.2f %n", maxArea);
        System.out.printf(shape.toString());
    }

    private static void findSecondValuePerimeter(ArrayList<Shape> shapesList) {
        double[] perimeterArray = new double[shapesList.size()];
        int counter = 0;
        Shape shape = shapesList.get(0);
        for (Shape x : shapesList) {
            perimeterArray[counter] = x.getPerimeter();
            counter++;
        }
        Arrays.sort(perimeterArray);
        for (Shape x : shapesList) {
            if (x.getPerimeter() == perimeterArray[perimeterArray.length -2]) {
                shape = x; break;
            }
        }
        System.out.printf("Второй по величине периметр: %.2f %n", shape.getPerimeter());
        System.out.printf(shape.toString());
    }
}
