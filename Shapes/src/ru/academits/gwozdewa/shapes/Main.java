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
        }*/
       /* for(Shape x: shapesArrayList)
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
        Shape shape;
        for (Shape x : shapesList) {
            if (x.getArea() > maxArea) {
                maxArea = x.getArea();
                index = counter;
            }
            counter++;
        }
        shape = shapesList.get(index);
        System.out.printf("Максимальная площадь: %.2f \n", maxArea);
        System.out.printf("Фигура: %s, Ширина: %.2f, Высота :  %.2f, Площадь:  %.2f, Периметр:  %.2f \n", shape.toString(), shape.getWidth(), shape.getHeight(), shape.getArea(), shape.getPerimeter());
    }

    private static void findSecondValuePerimeter(ArrayList<Shape> shapesList) {
        Double[] perimeterArray = new Double[shapesList.size()];
        int counter = 0;
        Shape shape = shapesList.get(0);
        for (Shape x : shapesList) {
            perimeterArray[counter] = shapesList.get(counter).getPerimeter();
            counter++;
        }
        Arrays.sort(perimeterArray, Collections.reverseOrder());
        for (Shape x : shapesList) {
            if (x.getPerimeter() == perimeterArray[1]) {
                shape = x;
            }
        }
        System.out.printf("Второй по величине периметр: %.2f \n", shape.getPerimeter());
        System.out.printf("Фигура: %s, Ширина: %.2f, Высота :  %.2f, Площадь:  %.2f, Периметр:  %.2f", shape.toString(), shape.getWidth(), shape.getHeight(), shape.getArea(), shape.getPerimeter());
    }
}
