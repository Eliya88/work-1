package Scalar;

public class IntegerScalar implements Scalar {

    private final int number;

    public IntegerScalar(int num) {
        this.number = num;
    }

    @Override
    public Scalar add(Scalar s) {
        return new RationalScalar(this.number * s.getDenominator() + s.getNumerator(), s.getDenominator());
    }

    @Override
    public Scalar mul(Scalar s) {
        return new RationalScalar(this.number * s.getNumerator(), s.getDenominator());
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(this.number * (-1));
    }

    @Override
    public Scalar power(int exp) {
        return new IntegerScalar((int) Math.pow(this.number, exp));
    }

    @Override
    public int sign() {
        return Integer.compare(this.number, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Scalar) {
            return this.number == ((Scalar) o).getNumerator();
        }
        return false;
    }

    @Override
    public int getNumerator() {
        return this.number;
    }

    @Override
    public int getDenominator() {
        return 1;
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }
}
