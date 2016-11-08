package ru.academits.gwozdewa.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;
    private int size;

    public Vector() {
    }

    //1.a	Vector(n) – размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        } else {
            vector = new double[n];
            size = n;
        }
    }

    //1.b	Vector(Vector) – конструктор копирования
    public Vector(Vector vector) {
        this(vector.getSize());
    }

    //1.c	Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] vector) {
        this.vector = vector;
        size = vector.length;
    }

    //1.d	Vector(n, double[]) – заполнение вектора значениями из массива.
    // Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] vector) {
        this.vector = new double[n];
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = vector[i];
        }
    }

    //2.	Метод getSize() для получения размерности вектора
    public int getSize() {
        return size;
    }

    //3.	Реализовать метод toString(), чтобы печатал вектор в  формате { значения компонент через запятую }
    public String toString() {
        return Arrays.toString(vector);
    }

    //4.a	Прибавление к вектору другого вектора
    public double[] addToVector(double[] vector, double[] addedVector) {
        if (vector.length == addedVector.length) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += addedVector[i];
            }
        } else if (vector.length > addedVector.length) {
            for (int i = 0; i < addedVector.length; i++) {
                vector[i] += addedVector[i];
            }
        } else {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += addedVector[i];
            }
        }
        return vector;
    }

    //4.b	Вычитание из вектора другого вектора
    public double[] deductFromVector(double[] vector, double[] deductibleVector) {
        if (vector.length == deductibleVector.length) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= deductibleVector[i];
            }
        } else if (vector.length > deductibleVector.length) {
            for (int i = 0; i < deductibleVector.length; i++) {
                vector[i] -= deductibleVector[i];
            }
        } else {
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= deductibleVector[i];
            }
        }
        return vector;
    }

    //4.c	Умножение вектора на скаляр
    public double[] scalarMultVector(double[] vector, double scalar) {
        double[] newVector = new double[vector.length];
        copyArray(vector, newVector);
        for (int i = 0; i < newVector.length; i++) {
            newVector[i] *= scalar;
        }
        return newVector;
    }

    //4.d	Разворот вектора (умножение всех компонент на -1)
    public double[] reverseVector(double[] vector) {
        double[] newVector = new double[vector.length];
        copyArray(vector, newVector);
        for (int i = 0; i < newVector.length; i++) {
            newVector[i] *= -1;
        }
        return newVector;
    }

    //4.e.	Получение длины вектора
    public double getNorm(double[] vector) {
        double norm = 0;
        double[] copyVector = new double[vector.length];
        copyArray(vector, copyVector);
        for (int i = 0; i < vector.length; i++) {
            norm += Math.pow(copyVector[i], 2);
        }
        return Math.sqrt(norm);
    }

    // 4.f	Получение и установка компоненты вектора по индексу
    public void setValue(double[] vector, int index, double value) {
        for (int i = 0; i < vector.length; i++) {
            if (i == index) {
                vector[i] = value;
            }
        }
    }

    public double getValue(double[] vector, int index) {
        return vector[index];
    }

    //5.a	Сложение двух векторов
    public static double[] sumVectors(double[] vectorOne, double[] vectorTwo) {
        double[] newVector;
        if (vectorOne.length == vectorTwo.length) {
            newVector = new double[vectorOne.length];
            for (int i = 0; i < newVector.length; i++) {
                newVector[i] = vectorOne[i] + vectorTwo[i];
            }
        } else if (vectorOne.length > vectorTwo.length) {
            newVector = new double[vectorOne.length];
            copyArray(vectorOne, newVector);
            for (int i = 0; i < vectorTwo.length; i++) {
                newVector[i] += vectorTwo[i];
            }
        } else {
            newVector = new double[vectorTwo.length];
            copyArray(vectorTwo, newVector);
            for (int i = 0; i < vectorOne.length; i++) {
                newVector[i] += vectorOne[i];
            }
        }
        return newVector;
    }

    //5.b	Вычитание векторов
    public static double[] differenceVectors(double[] vectorOne, double[] vectorTwo) {
        double[] newVector;
        if (vectorOne.length == vectorTwo.length) {
            newVector = new double[vectorOne.length];
            for (int i = 0; i < newVector.length; i++) {
                newVector[i] = vectorOne[i] - vectorTwo[i];
            }
        } else if (vectorOne.length > vectorTwo.length) {
            newVector = new double[vectorOne.length];
            copyArray(vectorOne, newVector);
            for (int i = 0; i < vectorTwo.length; i++) {
                newVector[i] -= vectorTwo[i];
            }
        } else {
            newVector = new double[vectorTwo.length];
            copyArray(vectorOne, newVector);
            for (int i = 0; i < newVector.length; i++) {
                newVector[i] -= vectorTwo[i];
            }
        }
        return newVector;
    }

    //5.c Скалярное произведение векторов
    public static double[] multVectors(double[] vectorOne, double[] vectorTwo) {
        double[] newVector;
        if (vectorOne.length == vectorTwo.length) {
            newVector = new double[vectorOne.length];
            for (int i = 0; i < newVector.length; i++) {
                newVector[i] = vectorOne[i] * vectorTwo[i];
            }
        } else if (vectorOne.length > vectorTwo.length) {
            newVector = new double[vectorOne.length];
            copyArray(vectorTwo, newVector);
            for (int i = 0; i < vectorTwo.length; i++) {
                newVector[i] *= vectorOne[i];
            }
        } else {
            newVector = new double[vectorTwo.length];
            copyArray(vectorOne, newVector);
            for (int i = 0; i < newVector.length; i++) {
                newVector[i] *= vectorTwo[i];
            }
        }
        return newVector;
    }

    private static double[] copyArray(double[] array, double[] copyArray) {
        for (int i = 0; i < array.length; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Vector v = (Vector) obj;
        if (size == v.size) {
            for (int i = 0; i < this.vector.length; i++) {
                double epsilon = 1.0e-4;
                if(!(Math.abs(this.vector[i] - v.vector[i]) <= epsilon))
                {
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
        hash = prime * hash + (int) size;
        return hash;
    }
}