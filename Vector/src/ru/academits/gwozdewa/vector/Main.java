package ru.academits.gwozdewa.vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 2};
        double[] array2 = {1, 1, 3};
        double[] array3 = {1, 2.0000002};
        Vector vector = new Vector();
        //Vector vector0 = new Vector(5);
        Vector vector1 = new Vector(array);
        Vector vector2 = new Vector(array3);
        //Vector vector2 = new Vector(vector);
        // Vector vector3 = new Vector(10, array);
        //  System.out.println(Arrays.toString(Vector.sumVectors(array, array)));
        //    System.out.println(Arrays.toString(Vector.sumVectors(array, array2)));
        //   System.out.println(Arrays.toString(Vector.differenceVectors(array, array2)));
        //   System.out.println(Arrays.toString(Vector.differenceVectors(array2, array)));
        // System.out.println(Arrays.toString(Vector.multVectors(array2, array)));
        // System.out.println(Arrays.toString(Vector.multVectors(array, array2)));
       // System.out.println(Arrays.toString(vector.scalarMultVector(array, 2)));
       // System.out.println(Arrays.toString(vector.reverseVector(array)));
       // System.out.printf("Длина вектора: %.2f " , vector.getNorm(array));
       // System.out.println(Arrays.toString(vector.addToVector(array2, array)));
       // System.out.println(Arrays.toString(vector.deductFromVector(array2, array)));
       // System.out.println(vector1.equals(vector2));
    }
}
