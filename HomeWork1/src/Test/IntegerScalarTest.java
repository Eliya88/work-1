package Test;

import static org.junit.jupiter.api.Assertions.*;
import Scalar.IntegerScalar;
import Scalar.Scalar;
import org.junit.jupiter.api.Test;

class IntegerScalarTest {

    @Test
    void testAdd() {
        int num1, num2, sum;

        for (int i = 0; i<= 100; i++) {
            num1 = i;
            num2 = i*2;
            sum = num1 + num2;

            Scalar s1 = new IntegerScalar(num1);
            Scalar s2 = new IntegerScalar(num2);
            assertEquals(s1.add(s2).toString(), String.valueOf(sum));
        }

    }

    @Test
    void mul() {
        int num1, num2, sum;

        for (int i = 0; i<= 100; i++) {
            num1 = i;
            num2 = i*2;
            sum = num1 * num2;

            Scalar s1 = new IntegerScalar(num1);
            Scalar s2 = new IntegerScalar(num2);
            assertEquals(s1.mul(s2).toString(), String.valueOf(sum));
        }
    }

    @Test
    void neg() {
        Scalar s1 = new IntegerScalar(-3);
        assertEquals(s1.neg().toString(), "3");

        Scalar s2 = new IntegerScalar(3);
        assertEquals(s2.neg().toString(), "-3");
    }

    @Test
    void power() {
        Scalar s1 = new IntegerScalar(-3);
        assertEquals(s1.power(2).toString(), "9");

        Scalar s2 = new IntegerScalar(3);
        assertEquals(s2.power(2).toString(), "9");

        Scalar s3 = new IntegerScalar(3);
        assertEquals(s3.power(0).toString(), "1");
    }

    @Test
    void sign() {
        Scalar s1 = new IntegerScalar(-3);
        assertEquals(s1.sign(), -1);

        Scalar s2 = new IntegerScalar(3);
        assertEquals(s2.sign(), 1);

        Scalar s3 = new IntegerScalar(0);
        assertEquals(s3.sign(), 0);
    }

    @Test
    void testEquals() {
        Scalar s1 = new IntegerScalar(3);
        Scalar s2 = new IntegerScalar(3);
        assertEquals(s1, s2);

        Scalar s3 = new IntegerScalar(-3);
        Scalar s4 = new IntegerScalar(-3);
        assertEquals(s3, s4);

        Scalar s5 = new IntegerScalar(0);
        Scalar s6 = new IntegerScalar(0);
        assertEquals(s5, s6);

        Scalar s7 = new IntegerScalar(3);
        Scalar s8 = new IntegerScalar(4);
        assertNotEquals(s7, s8);
    }

    @Test
    void testToString() {
        Scalar s1 = new IntegerScalar(-3);
        assertEquals(s1.toString(), "-3");

        Scalar s2 = new IntegerScalar(3);
        assertEquals(s2.toString(), "3");

        Scalar s3 = new IntegerScalar(0);
        assertEquals(s3.toString(), "0");
    }
}