package ru.academits.gwozdewa.range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range();
        Range range2 = new Range(1, 3);
        System.out.println("Длина интервала: " + range2.calculateLengthOfRange());
        if (range.findIntersection(range2) != null) {
            System.out.println("Интервал пересечения: [" + range.findIntersection(range2).getFrom() + ", " + range.findIntersection(range2).getTo() + "]");
        } else {
            System.out.println("Пересечений нет");
        }

        if (range.findUnion(range2).length != 1) {
            double fromOne = range.findUnion(range2)[0].getFrom();
            double fromTwo = range.findUnion(range2)[1].getFrom();
            double toOne = range.findUnion(range2)[0].getTo();
            double toTwo = range.findUnion(range2)[1].getTo();
            System.out.println("Интервалы объединения: [" + fromOne + ", " + toOne + "], [" + fromTwo + ", " + toTwo + "]");
        } else {
            double from = range.findUnion(range2)[0].getFrom();
            double to = range.findUnion(range2)[0].getTo();
            System.out.println("Интервал объединения: [" + from + ", " + to + "]");
        }

        if (range.findDifference(range2) == null) {
            System.out.println("Разности нет");
        } else {
            double fromOne = range.findDifference(range2)[0].getFrom();
            double fromTwo = range.findDifference(range2)[1].getFrom();
            double toOne = range.findDifference(range2)[0].getTo();
            double toTwo = range.findDifference(range2)[1].getTo();
            System.out.println("Интервалы разности: [" + fromOne + ", " + toOne + "], [" + fromTwo + ", " + toTwo + "]");
        }
    }
}
