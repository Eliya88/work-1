package Scalar;

public interface Scalar {

    Scalar add(Scalar s);

    Scalar mul(Scalar s);

    Scalar neg();

    Scalar power(int exp);

    int sign();

    boolean equals(Object o);

    String toString();

    int getNumerator();

    int getDenominator();
}
