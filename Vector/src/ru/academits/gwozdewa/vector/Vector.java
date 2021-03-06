package ru.academits.gwozdewa.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    //1.a	Vector(n) – размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        } else {
            vector = new double[n];
        }
    }

    //1.b	Vector(Vector) – конструктор копирования
    public Vector(Vector vector) {
        this(vector.getSize(), vector.getVector());
    }

    //1.c	Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] vector) {
        this.vector = vector;
    }

    //1.d	Vector(n, double[]) – заполнение вектора значениями из массива.
    // Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] vector) {
        this.vector = new double[n];
        double[] copyVector = new double[n];
        if (n < vector.length) {
            System.arraycopy(vector, 0, copyVector, 0, n);
            System.arraycopy(copyVector, 0, this.vector, 0, n);
        } else {
            System.arraycopy(vector, 0, copyVector, 0, vector.length);
            System.arraycopy(copyVector, 0, this.vector, 0, vector.length);
        }
    }

    //2.	Метод getSize() для получения размерности вектора
    public int getSize() {
        return vector.length;
    }

    public double[] getVector() {
        return vector;
    }

    //3.	Реализовать метод toString(), чтобы печатал вектор в  формате { значения компонент через запятую }
    public String toString() {
        return Arrays.toString(vector);
    }

    //4.a	Прибавление к вектору другого вектора
    public Vector addToVector(Vector addedVector) {
        if (vector.length == addedVector.getSize()) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += addedVector.getValue(i);
            }
        } else if (vector.length > addedVector.getSize()) {
            for (int i = 0; i < addedVector.getSize(); i++) {
                vector[i] += addedVector.getValue(i);
            }
        } else {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += addedVector.getValue(i);
            }
        }
        return new Vector(vector);
    }

    //4.b	Вычитание из вектора другого вектора
    public Vector deductFromVector(Vector deductibleVector) {
        if (vector.length == deductibleVector.getSize()) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= deductibleVector.getValue(i);
            }
        } else if (vector.length > deductibleVector.getSize()) {
            for (int i = 0; i < deductibleVector.getSize(); i++) {
                vector[i] -= deductibleVector.getValue(i);
            }
        } else {
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= deductibleVector.getValue(i);
            }
        }
        return new Vector(vector);
    }

    //4.c	Умножение вектора на скаляр
    public double[] scalarMultVector(double scalar) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= scalar;
        }
        return vector;
    }

    //4.d	Разворот вектора (умножение всех компонент на -1)
    public double[] reverseVector() {
        scalarMultVector(-1);
        return vector;
    }

    //4.e.	Получение длины вектора
    public double getNorm() {
        double norm = 0;
        for (double aVector : vector) {
            norm += Math.pow(aVector, 2);
        }
        return Math.sqrt(norm);
    }

    // 4.f	Получение и установка компоненты вектора по индексу
    public void setValue(int index, double value) {
        if (index >= vector.length || index < 0) {
            throw new IndexOutOfBoundsException("Индекс за пределами границ");
        } else {
            for (int i = 0; i < vector.length; i++) {
                if (i == index) {
                    vector[i] = value;
                }
            }
        }
    }

    public double getValue(int index) {
        if (index >= vector.length || index < 0) {
            throw new IndexOutOfBoundsException("Индекс за пределами границ");
        } else {
            return vector[index];
        }
    }

    //5.a	Сложение двух векторов
    public static Vector sumVectors(Vector vectorOne, Vector vectorTwo) {
        return new Vector(vectorOne).addToVector(vectorTwo);
    }


    //5.b	Вычитание векторов
    public static Vector differenceVectors(Vector vectorOne, Vector vectorTwo) {
        return new Vector(vectorOne).deductFromVector(vectorTwo);
    }

    //5.c Скалярное произведение векторов
    public static double multVectors(Vector vectorOne, Vector vectorTwo) {
        double scalarMult = 0;
        if (vectorOne.getSize() == vectorTwo.getSize() || vectorOne.getSize() < vectorTwo.getSize()) {
            for (int i = 0; i < vectorOne.getSize(); i++) {
                scalarMult += vectorOne.getValue(i) * vectorTwo.getValue(i);
            }
        } else if (vectorOne.getSize() > vectorTwo.getSize()) {
            for (int i = 0; i < vectorTwo.getSize(); i++) {
                scalarMult += vectorOne.getValue(i) * vectorTwo.getValue(i);
            }
        }
        return scalarMult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Vector v = (Vector) obj;
        if (vector.length == v.getSize()) {
            for (int i = 0; i < this.vector.length; i++) {
                double epsilon = 1.0e-4;
                if (Math.abs(this.vector[i] - v.vector[i]) > epsilon) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (int) vector.length;
        return hash;
    }
}
