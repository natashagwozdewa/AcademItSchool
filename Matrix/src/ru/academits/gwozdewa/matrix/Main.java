package ru.academits.gwozdewa.matrix;


import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {


    }

    public static void printMatrix(int[][] array)
    {
        for (int i = 0; i < array.length; i++) { //строки

            for (int j = 0; j < array[i].length; j++) { //столбцы
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
