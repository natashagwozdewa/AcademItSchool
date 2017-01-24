package ru.academits.gwozdewa.matrix;

import com.sun.javafx.geom.Matrix3f;
import ru.academits.gwozdewa.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       // double[][] array = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
       // double[][] array2 = {{4, 2}, {9, 0}};
      //  double[][] array3 = {{3,1},{-3,4}};

        double [][] array4 = {{-1, 3}, {0, 1}, {2, -2}};
        double[][] array5 = {{0, 2, 0, -1}, {1, -3, 4, 0}};
      //  Vector[] vectorsArray;
      //  double[] arrayVector = {1, 2, -1};
       /* Vector vectorStr = new Vector(arrayVector);
        vectorsArray = new Vector[array.length];
        for (int i = 0; i < vectorsArray.length; i++) {
            vectorsArray[i] = new Vector(array[i].length);
            for (int j = 0; j < vectorsArray[i].getSize(); j++) {
                vectorsArray[i].setValue(j, array[i][j]);
            }
        }*/
        // Matrix matrix = new Matrix(2, 3);
        //Matrix matrix = new Matrix(array5);
       // Matrix squareMatrix = new Matrix(array2);
      // Matrix squareMatrix2 = new Matrix(array3);

        Matrix matrix1 = new Matrix(array4);
        Matrix matrix2 = new Matrix(array5);
        // Matrix matrix = new Matrix(vectorsArray);
        // System.out.println(Arrays.toString(vectorsArray));
       // System.out.println(matrix.toString());
        // System.out.println(matrix.getNumberOfRows());
        // System.out.println(matrix.getNumberOfColumns());
        // matrix.setVectorStrToMatrix(0, vectorStr);
        //System.out.println(matrix.toString());
        // System.out.println(matrix.getVectorStrFromMatrix(0).toString());
        // System.out.println(matrix.getVectorColumnFromMatrix(0).toString());
        // System.out.println(squareMatrix.toString());
        //  System.out.println(squareMatrix.toString());
        // matrix.multMatrixOnScalar(2);
       // System.out.println(squareMatrix.findDeterminantOfMatrix());
       // System.out.println(matrix.findDeterminantOfMatrix());
        // System.out.println(matrix.toString());
       // System.out.println(matrix.multMatrixOnVector(vectorStr));
       // squareMatrix.addMatrix(squareMatrix2);
       // squareMatrix.deductMatrix(squareMatrix2);
       // System.out.println(squareMatrix.toString());
       // System.out.println(Matrix.addMatrix(squareMatrix, squareMatrix2));
      //  System.out.println(Matrix.deductMatrix(squareMatrix, squareMatrix2));
        System.out.println(Matrix.multMatrix(matrix1, matrix2));
        System.out.println(matrix1.toString());
        System.out.println(matrix2.toString());
       // System.out.println(Arrays.toString(Matrix.transpositionMatrix(squareMatrix)));
       // System.out.println(matrix.toString());
      //  matrix.transpositionMatrix();
      //  System.out.println(matrix.toString());
    }
}
