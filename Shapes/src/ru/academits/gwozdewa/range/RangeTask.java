package ru.academits.gwozdewa.range;

public class RangeTask {
    public static void main(String[] args) {
        Range range = new Range();
        Range range1 = new Range(4, 7);
        Range range2 = new Range(2, 6);
        //    System.out.println("Длина интервала: " + range1.calculateLengthOfRange());
        if (range.findIntersection(range1, range2) != null) {
            double from = range.findIntersection(range1, range2).getFrom();
            double to = range.findIntersection(range1, range2).getTo();
            System.out.println("Интервал пересечения: [" + range.findIntersection(range1, range2).getFrom() + ", " + range.findIntersection(range1, range2).getTo() + "]");
        } else {
            System.out.println("Пересечений нет");
        }

        if (range.findUnion(range1, range2)[1] != null) {
            double fromOne = range.findUnion(range1, range2)[0].getFrom();
            double fromTwo = range.findUnion(range1, range2)[1].getFrom();
            double toOne = range.findUnion(range1, range2)[0].getTo();
            double toTwo = range.findUnion(range1, range2)[1].getTo();
            System.out.println("Интервалы объединения: [" + fromOne + ", " + toOne + "], [" + fromTwo + ", " + toTwo + "]");
        } else {
            double from = range.findUnion(range1, range2)[0].getFrom();
            double to = range.findUnion(range1, range2)[0].getTo();
            System.out.println("Интервал объединения: [" + from + ", " + to + "]");
        }

        if (range.findDifference(range1, range2) == null) {
            System.out.println("Разности нет");
        } else {
            if (range.findDifference(range1, range2)[1] != null) {
                double fromOne = range.findDifference(range1, range2)[0].getFrom();
                double fromTwo = range.findDifference(range1, range2)[1].getFrom();
                double toOne = range.findDifference(range1, range2)[0].getTo();
                double toTwo = range.findDifference(range1, range2)[1].getTo();
                System.out.println("Интервалы разности: [" + fromOne + ", " + toOne + "], [" + fromTwo + ", " + toTwo + "]");
            } else {
                double from = range.findDifference(range1, range2)[0].getFrom();
                double to = range.findDifference(range1, range2)[0].getTo();
                System.out.println("Интервал разности: [" + from + ", " + to + "]");
            }
        }
    }
}

class Range {
    private double from;
    private double to;

    Range() {
    }

    Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    double getFrom() {
        return this.from;
    }

    double getTo() {
        return this.to;
    }

    double calculateLengthOfRange() {
        return Math.abs(to - from);
    }

    boolean isInside(double number) {
        return (number >= from && number <= to);
    }

    private boolean isNotCross(Range rangeOne, Range rangeTwo) {
        return rangeOne.from > rangeTwo.to || rangeOne.to < rangeTwo.from;
    }

    private boolean isSecondIntervalAfterFirst(Range rangeOne, Range rangeTwo) {
        return rangeOne.from <= rangeTwo.from && rangeOne.to <= rangeTwo.to;
    }

    private boolean isFirstIntervalInSecond(Range rangeOne, Range rangeTwo) {
        return rangeTwo.from <= rangeOne.from && rangeOne.to <= rangeTwo.to;
    }

    private boolean isSecondIntervalInFirst(Range rangeOne, Range rangeTwo) {
        return rangeOne.from <= rangeTwo.from && rangeTwo.to <= rangeOne.to;
    }

    Range findIntersection(Range rangeOne, Range rangeTwo) {
        if (isNotCross(rangeOne, rangeTwo)) {
            return null;
        } else {
            if (isSecondIntervalInFirst(rangeOne, rangeTwo)) {
                return new Range(rangeTwo.from, rangeTwo.to);
            } else if (isFirstIntervalInSecond(rangeOne, rangeTwo)) {
                return new Range(rangeOne.from, rangeOne.to);
            }
            if (isSecondIntervalAfterFirst(rangeOne, rangeTwo)) {
                return new Range(rangeTwo.from, rangeOne.to);
            } else {
                return new Range(rangeOne.from, rangeTwo.to);
            }
        }
    }

    Range[] findUnion(Range rangeOne, Range rangeTwo) {
        Range[] rangeArray = new Range[2];
        if (isNotCross(rangeOne, rangeTwo)) {
            rangeArray[0] = rangeOne;
            rangeArray[1] = rangeTwo;
            return rangeArray;
        } else {
            if (isSecondIntervalInFirst(rangeOne, rangeTwo)) {
                rangeArray[0] = rangeOne;
            } else if (isFirstIntervalInSecond(rangeOne, rangeTwo)) {
                rangeArray[0] = rangeTwo;
            } else if (isSecondIntervalAfterFirst(rangeOne, rangeTwo)) {
                rangeArray[0] = new Range(rangeOne.from, rangeTwo.to);
            } else {
                rangeArray[0] = new Range(rangeTwo.from, rangeOne.to);
            }
        }
        return rangeArray;
    }

    Range[] findDifference(Range rangeOne, Range rangeTwo) {
        Range[] rangeArray = new Range[2];
        if (rangeOne.from != rangeTwo.from && rangeOne.to != rangeTwo.to) {
            rangeArray[0] = new Range(findUnion(rangeOne, rangeTwo)[0].getFrom(), findIntersection(rangeOne, rangeTwo).getFrom());
            rangeArray[1] = new Range(findIntersection(rangeOne, rangeTwo).getTo(), findUnion(rangeOne, rangeTwo)[0].getTo());
        } else {
            if (rangeOne.from == rangeTwo.from && rangeOne.to == rangeTwo.to) {
                return null;
            }
            if (rangeOne.from == rangeTwo.from) {
                rangeArray[0] = new Range(findIntersection(rangeOne, rangeTwo).getTo(), findUnion(rangeOne, rangeTwo)[0].getTo());
            } else // if(rangeOne.to == rangeTwo.to)
            {
                rangeArray[0] = new Range(findUnion(rangeOne, rangeTwo)[0].getFrom(), findIntersection(rangeOne, rangeTwo).getFrom());
            }
        }
        return rangeArray;
    }
}