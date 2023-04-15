package Expression;

import Scalar.*;

public class Monomial {

    private final int exponent;
    private final Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        if (exponent < 0)
            throw new IllegalArgumentException("Exponent cannot be negative");
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m) {
        if (this.exponent != m.exponent)
            return null;
        return new Monomial(this.exponent, this.coefficient.add(m.coefficient));
    }

    public Monomial mul(Monomial m) {
        return new Monomial(this.exponent + m.exponent, this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s) {
        return this.coefficient.mul(s.power(this.exponent));
    }

    public Monomial derivative() {
        if (this.exponent == 0)
            return new Monomial(0, new IntegerScalar(0));
        return new Monomial(this.exponent - 1,
                this.coefficient.mul(new IntegerScalar(this.exponent)));
    }

    public int sign() {
        return this.coefficient.sign();
    }

    public boolean equals(Object o) {
        return o instanceof Monomial && (this.exponent == ((Monomial) o).exponent) &&
                (this.coefficient.equals(((Monomial) o).coefficient));
    }

    public String toString() {
        if (this.exponent == 0)
            return this.coefficient.toString();
        else if (this.exponent == 1)
            return this.coefficient.toString() + "x";
        else if (this.coefficient.toString() == "0")
            return "0";
        else if (this.coefficient.toString() == "1")
            return "x^" + this.exponent;
        else if (this.coefficient.toString() == "-1")
            return "-x^" + this.exponent;

        return this.coefficient.toString() + "x^" + this.exponent;
    }
}
