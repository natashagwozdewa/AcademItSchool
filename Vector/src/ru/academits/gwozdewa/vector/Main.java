package ru.academits.gwozdewa.vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 2};
        double[] array2 = {1, 1, 3};
        double[] array3 = {1, 2.0000002};
        //Vector vector0 = new Vector(5);
        Vector vector = new Vector(array);
        Vector vector2 = new Vector(array2);
       // Vector vectorCopy = new Vector(vector1);
       // System.out.println(vector1.toString());
       // System.out.println(vectorCopy.toString());
       //  Vector vector3 = new Vector(1, array);
      //  System.out.println(vector3.toString());
        //  System.out.println(Arrays.toString(Vector.sumVectors(array, array)));
     //   System.out.println(vector.addToVector(vector2));
      //  System.out.println(vector.addToVector(vector2).toString());
          //  System.out.println(Vector.sumVectors(vector, vector2));
       // System.out.println(vector.deductFromVector(vector2));
        //System.out.println(Vector.differenceVectors(vector2,vector));
       // vector.reverseVector();
        System.out.println(Vector.multVectors(vector2, vector));
      //  System.out.println(vector.toString());
      //  System.out.println(vector2.toString());
        //   System.out.println(Arrays.toString(Vector.differenceVectors(array, array2)));
        //   System.out.println(Arrays.toString(Vector.differenceVectors(array2, array)));
        // System.out.println(Arrays.toString(Vector.multVectors(array2, array)));
        // System.out.println(Arrays.toString(Vector.multVectors(array, array2)));
       // System.out.println(Arrays.toString(vector2.reverseVector()));
       // System.out.println(Arrays.toString(vector.scalarMultVector(2)));
       // System.out.println(vector.toString());
       // vector.setValue(0,5);
      // System.out.println(vector.toString());
      //  System.out.println(vector2.getValue(2));
       // System.out.printf("Длина вектора: %.2f " , vector2.getNorm());

       // System.out.println(Arrays.toString(vector2.addToVector(array)));
      // System.out.println(Arrays.toString(vector2.deductFromVector(array)));
       // System.out.println(vector1.equals(vector2));
    }
}
