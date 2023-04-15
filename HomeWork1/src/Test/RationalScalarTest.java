package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Scalar.*;

class RationalScalarTest {

    @Test
    void add() {
        Scalar s1 = new RationalScalar(2, 4);
        Scalar s2 = new RationalScalar(3, 2);
        assertEquals(s1.add(s2).toString(), "2");

        Scalar s3 = new RationalScalar(-5, 12);
        assertEquals(s1.add(s3).toString(), "-1/12");
    }

    @Test
    void mul() {
    }

    @Test
    void neg() {
    }

    @Test
    void power() {
    }

    @Test
    void sign() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void reduce() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getNumerator() {
    }

    @Test
    void getDenominator() {
    }
}