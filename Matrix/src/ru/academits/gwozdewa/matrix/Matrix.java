package ru.academits.gwozdewa.matrix;


import ru.academits.gwozdewa.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    private double getElement(int numberRow, int numberColumn) {
        return rows[numberRow].getValue(numberColumn);
    }

    private void setElement(int numberRow, int numberColumn, double value) {
        rows[numberRow].setValue(numberColumn, value);
    }

    //1.a.	Matrix(n, m) – матрица нулей размера nxm
    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Кол-во строк, столбцов должно быть больше 0");
        } else {
            rows = new Vector[n];
            for (int i = 0; i < n; i++) {
                rows[i] = new Vector(m);
            }
        }
    }

    //1.b.	Matrix(Matrix) – конструктор копирования
    public Matrix(Matrix copyMatrix) {
        this(copyMatrix.getMatrix());
    }

    //1.c.	Matrix(double[][]) – из двумерного массива
    public Matrix(double[][] array) {
        rows = new Vector[array.length];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(array[i].length);
            for (int j = 0; j < rows[i].getSize(); j++) {
                rows[i].setValue(j, array[i][j]);
            }
        }
    }

    //1.d.	Matrix(Vector[]) – из массива векторов-строк
    public Matrix(Vector[] vectorsArray) {
        rows = new Vector[vectorsArray.length];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(vectorsArray[i].getSize());
            for (int j = 0; j < rows[i].getSize(); j++) {
                rows[i].setValue(j, vectorsArray[i].getValue(j));
            }
        }
    }

    public Vector[] getMatrix() {
        return rows;
    }


    public String toString() {
        return Arrays.toString(rows);
    }

    //2.a.	Получение размеров матрицы
    public int getNumberOfRows() {
        return rows.length;
    }

    public int getNumberOfColumns() {
        return rows[0].getSize();
    }

    //2.b.	Получение и задание вектора-строки по индексу
    public void setVectorStrToMatrix(int indexOfStr, Vector vectorStr) {
        if (indexOfStr < 0 && indexOfStr > getNumberOfRows()) {
            throw new IndexOutOfBoundsException("Индекс за пределами границ");
        } else {
            rows[indexOfStr] = vectorStr;
        }
    }

    public Vector getVectorStrFromMatrix(int indexOfStr) {
        if (indexOfStr < 0 && indexOfStr > getNumberOfRows()) {
            throw new IndexOutOfBoundsException("Индекс за пределами границ");
        } else {
            return rows[indexOfStr];
        }
    }

    //2.c.	Получение вектора-столбца по индексу
    public Vector getVectorColumnFromMatrix(int indexOfColumn) {
        if (indexOfColumn < 0 && indexOfColumn > getNumberOfColumns()) {
            throw new IndexOutOfBoundsException("Индекс за пределами границ");
        } else {
            Vector arrayColumn = new Vector(getNumberOfRows());
            for (int i = 0; i < getNumberOfRows(); i++) {
                arrayColumn.setValue(i, rows[i].getValue(indexOfColumn));
            }
            return arrayColumn;
        }
    }

    //2.d.	Транспонирование матрицы
    public void transpositionMatrix()
    {
        Vector[] transpMatrix = new Vector[getNumberOfColumns()];
        for (int i = 0; i < getNumberOfColumns(); i++) {
            transpMatrix[i] = new Vector(getNumberOfRows());
        }
        for (int i = 0; i < getNumberOfRows(); i++) {
            for (int j = 0; j < getNumberOfColumns(); j++) {
                transpMatrix[j].setValue(i, getElement(i, j));
            }
        }
        rows = transpMatrix;
    }

    //2.e.	Умножение на скаляр
    public void multMatrixOnScalar(double scalar) {
        for (int i = 0; i < getNumberOfRows(); i++) {
            rows[i].scalarMultVector(scalar);
        }
    }

    //2.f.	Вычисление определителя матрицы
    public double findDeterminantOfMatrix() {
        double determinant = 0;
        if (getNumberOfRows() == getNumberOfColumns()) {
            if (getNumberOfRows() == 2) {
                determinant = rows[0].getValue(0) * rows[1].getValue(1) - rows[0].getValue(1) * rows[1].getValue(0);
            } else if (getNumberOfRows() == 3) {
                determinant = rows[0].getValue(0) * rows[1].getValue(1) * rows[2].getValue(2) +
                        rows[0].getValue(1) * rows[1].getValue(2) * rows[2].getValue(0) +
                        rows[0].getValue(2) * rows[1].getValue(0) * rows[2].getValue(1) -
                        rows[0].getValue(2) * rows[1].getValue(1) * rows[2].getValue(0) -
                        rows[0].getValue(1) * rows[1].getValue(0) * rows[2].getValue(2) -
                        rows[0].getValue(0) * rows[1].getValue(2) * rows[2].getValue(1);
            }
        } else {
            System.out.println("Матрица должна быть квадратной");
        }
        return determinant;
    }

    //2.h.	умножение матрицы на вектор
    public Vector multMatrixOnVector(Vector vector) {
        Vector resultVector = new Vector(getNumberOfRows());
        if (getNumberOfColumns() == vector.getSize()) {
            double tmp = 0;
            for (int i = 0; i < getNumberOfRows(); i++) {
                for (int j = 0; j < getNumberOfColumns(); j++) {
                    tmp += rows[i].getValue(j) * vector.getValue(j);
                }
                resultVector.setValue(i, tmp);
                tmp = 0;
            }
        } else {
            System.out.println("Число столбцов в матрице должно совпадать с числом строк в векторе");
        }
        return resultVector;
    }

    //2.i.	Сложение матриц
    public void addMatrix(Matrix addedMatrix) {
        if (getNumberOfRows() == addedMatrix.getNumberOfRows() && getNumberOfColumns() == addedMatrix.getNumberOfColumns()) {
            for (int i = 0; i < getNumberOfRows(); i++) {
                for (int j = 0; j < getNumberOfColumns(); j++) {
                    rows[i].setValue(j, rows[i].getValue(j) + addedMatrix.getElement(i, j));
                }
            }
        } else {
            System.out.println("Матрицы должны быть одинаковой размерности");
        }
    }

    //2.j.	Вычитание матриц
    public void deductMatrix(Matrix deductibleMatrix) {
        if (getNumberOfRows() == deductibleMatrix.getNumberOfRows() && getNumberOfColumns() == deductibleMatrix.getNumberOfColumns()) {
            for (int i = 0; i < getNumberOfRows(); i++) {
                for (int j = 0; j < getNumberOfColumns(); j++) {
                    rows[i].setValue(j, rows[i].getValue(j) - deductibleMatrix.getElement(i, j));
                }
            }
        } else {
            System.out.println("Матрицы должны быть одинаковой размерности");
        }
    }

    //3.a.	Сложение матриц
    public static Matrix addMatrix(Matrix firstMatrix, Matrix secondMatrix) {
        Matrix resultMatrix = new Matrix(firstMatrix.getNumberOfRows(), firstMatrix.getNumberOfColumns());
        if (firstMatrix.getNumberOfRows() == secondMatrix.getNumberOfRows() && firstMatrix.getNumberOfColumns() == secondMatrix.getNumberOfColumns()) {
            for (int i = 0; i < resultMatrix.getNumberOfRows(); i++) {
                for (int j = 0; j < resultMatrix.getNumberOfColumns(); j++) {
                    resultMatrix.setElement(i, j, firstMatrix.getElement(i, j) + secondMatrix.getElement(i, j));
                }
            }
        } else {
            System.out.println("Матрицы должны быть одинаковой размерности");
        }
        return resultMatrix;
    }

    //3.b.	Вычитание матриц
    public static Matrix deductMatrix(Matrix firstMatrix, Matrix secondMatrix) {
        Matrix resultMatrix = new Matrix(firstMatrix.getNumberOfRows(), firstMatrix.getNumberOfColumns());
        if (firstMatrix.getNumberOfRows() == secondMatrix.getNumberOfRows() && firstMatrix.getNumberOfColumns() == secondMatrix.getNumberOfColumns()) {
            for (int i = 0; i < resultMatrix.getNumberOfRows(); i++) {
                for (int j = 0; j < resultMatrix.getNumberOfColumns(); j++) {
                    resultMatrix.setElement(i, j, firstMatrix.getElement(i, j) - secondMatrix.getElement(i, j));
                }
            }
        } else {
            System.out.println("Матрицы должны быть одинаковой размерности");
        }
        return resultMatrix;
    }
    //3.c.	Умножение матриц
    public static Matrix multMatrix(Matrix firstMatrix, Matrix secondMatrix)
    {
        Matrix resultMatrix = new Matrix(firstMatrix.getNumberOfRows(), secondMatrix.getNumberOfColumns());
        if(firstMatrix.getNumberOfColumns() == secondMatrix.getNumberOfRows())
        {
           int value = 0;
           for(int i = 0; i< resultMatrix.getNumberOfRows(); i++)
           {
               for(int j =0; j< resultMatrix.getNumberOfColumns(); j++)
               {
                   for(int s = 0; s< firstMatrix.getNumberOfColumns(); s++)
                   {
                       value += firstMatrix.getElement(i, s) * secondMatrix.getElement(s, j);
                   }
                   resultMatrix.setElement(i, j, value);
                   value = 0;
               }
           }
        }

        else
        {
            System.out.println("Число столбцов первой матрицы должно быть равно числу строк второй матрицы");
        }
        return resultMatrix;
    }

}
