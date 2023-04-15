package Scalar;

public class RationalScalar implements Scalar {

    private final int numerator, denominator;

    public RationalScalar(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Denominator cannot be 0");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Scalar add(Scalar s) {
        return new RationalScalar(this.numerator * s.getDenominator() + s.getNumerator() * this.denominator,
                this.denominator * s.getDenominator());
    }

    @Override
    public Scalar mul(Scalar s) {
        return new RationalScalar(this.numerator * s.getNumerator(),
                this.denominator * s.getDenominator());
    }

    @Override
    public Scalar neg() {
        return new RationalScalar(this.numerator * (-1), this.denominator);
    }

    @Override
    public Scalar power(int exp) {
        return new RationalScalar((int) Math.pow(this.numerator, exp), (int) Math.pow(this.denominator, exp));
    }

    @Override
    public int sign() {
        if (this.numerator == 0)
            return 0;
        if (Integer.compare(this.numerator, 0) == Integer.compare(this.denominator, 0))
            return 1;
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Scalar && (this.numerator * ((Scalar) obj).getDenominator() ==
                this.denominator * ((Scalar) obj).getNumerator());
    }

    public RationalScalar reduce() {
        return new RationalScalar(this.numerator / greatestCommonDivisor(this.numerator, this.denominator),
                this.denominator / greatestCommonDivisor(this.numerator, this.denominator));
    }

    @Override
    public String toString() {
        RationalScalar reduced = this.reduce();

        if (reduced.denominator == 1)
            return String.valueOf(reduced.numerator);
        else if (reduced.numerator == 0)
            return "0";
        else
            return String.valueOf(reduced.numerator) + "/" + String.valueOf(reduced.denominator);
    }

    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public int getDenominator() {
        return denominator;
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0)
            return a;
        return greatestCommonDivisor(b, a % b);
    }
}
