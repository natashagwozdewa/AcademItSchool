package ru.academits.gwozdewa.range;

public class Range {
    private double from = 2;
    private double to = 5;

    public Range() {
    }

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return this.from;
    }

    public double getTo() {
        return this.to;
    }

    public double calculateLengthOfRange() {
        return to - from;
    }

    boolean isInside(double number) {
        return (number >= from && number <= to);
    }

    private boolean isNotCross(Range rangeTwo) {
        return this.from > rangeTwo.to || this.to < rangeTwo.from;
    }

    public Range findIntersection(Range rangeTwo) {
        if (isNotCross(rangeTwo)) {
            return null;
        } else {
            return new Range(Math.max(this.from, rangeTwo.from), Math.min(this.to, rangeTwo.to));
        }
    }

    public Range[] findUnion(Range rangeTwo) {
        if (isNotCross(rangeTwo)) {
            return new Range[]{new Range(this.from, this.to), rangeTwo};
        } else {
            return new Range[]{new Range(Math.min(this.from, rangeTwo.from), Math.max(this.to, rangeTwo.to))};
        }
    }

    public Range[] findDifference(Range rangeTwo) {
        if (this.from == rangeTwo.from && this.to == rangeTwo.to) {
            return null;
        } else if (isNotCross(rangeTwo)) {
            return new Range[]{new Range(this.from, this.to), rangeTwo};
        } else {
            return new Range[]{new Range(findUnion(rangeTwo)[0].getFrom(), findIntersection(rangeTwo).getFrom()), new Range(findIntersection(rangeTwo).getTo(), findUnion(rangeTwo)[0].getTo())};
        }
    }
}
