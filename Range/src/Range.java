
public class Range {
    private double from = 4;
    private double to = 7;

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

    private boolean isSecondIntervalAfterFirst(Range rangeTwo) {
        return this.from <= rangeTwo.from && this.to <= rangeTwo.to;
    }

    private boolean isFirstIntervalInSecond(Range rangeTwo) {
        return rangeTwo.from <= this.from && this.to <= rangeTwo.to;
    }

    private boolean isSecondIntervalInFirst(Range rangeTwo) {
        return this.from <= rangeTwo.from && rangeTwo.to <= this.to;
    }

    public Range findIntersection(Range rangeTwo) {
        if (isNotCross(rangeTwo)) {
            return null;
        } else {
            if (isSecondIntervalInFirst(rangeTwo)) {
                return new Range(rangeTwo.from, rangeTwo.to);
            } else if (isFirstIntervalInSecond(rangeTwo)) {
                return new Range(this.from, this.to);
            }
            if (isSecondIntervalAfterFirst(rangeTwo)) {
                return new Range(rangeTwo.from, this.to);
            } else {
                return new Range(this.from, rangeTwo.to);
            }
        }
    }

    public Range[] findUnion(Range rangeTwo) {
        if (isNotCross(rangeTwo)) {
            return new Range[]{new Range(this.from, this.to), rangeTwo};
        } else {
            if (isSecondIntervalInFirst(rangeTwo)) {
                return new Range[]{new Range(this.from, this.to)};
            } else if (isFirstIntervalInSecond(rangeTwo)) {
                return new Range[]{rangeTwo};
            } else if (isSecondIntervalAfterFirst(rangeTwo)) {
                return new Range[]{new Range(this.from, rangeTwo.to)};
            } else {
                return new Range[]{new Range(rangeTwo.from, this.to)};
            }
        }
    }

    public Range[] findDifference(Range rangeTwo) {
        if (this.from != rangeTwo.from && this.to != rangeTwo.to) {
            return new Range[]{new Range(findUnion(rangeTwo)[0].getFrom(), findIntersection(rangeTwo).getFrom()), new Range(findIntersection(rangeTwo).getTo(), findUnion(rangeTwo)[0].getTo())};
        } else {
            if (this.from == rangeTwo.from && this.to == rangeTwo.to) {
                return new Range[]{};
            }
            if (this.from == rangeTwo.from) {
                return new Range[]{new Range(findIntersection(rangeTwo).getTo(), findUnion(rangeTwo)[0].getTo())};
            } else // if(rangeOne.to == rangeTwo.to)
            {
                return new Range[]{new Range(findUnion(rangeTwo)[0].getFrom(), findIntersection(rangeTwo).getFrom())};
            }
        }
    }
}
