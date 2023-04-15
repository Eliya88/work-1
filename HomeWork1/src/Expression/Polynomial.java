package Expression;

import Scalar.IntegerScalar;
import Scalar.RationalScalar;
import Scalar.Scalar;
import java.util.Objects;

public class Polynomial {

    private Monomial[] monomials = new Monomial[0];

    private Polynomial(String[] mono) {

        for (int i = mono.length - 1; i >= 0; i--) {
            if (mono[i] != null) {
                this.monomials = new Monomial[i + 1];
                break;
            }
        }
        String num, dum;
        for (int i = 0; i < this.monomials.length; i++) {
            if (mono[i].contains("/")) {
                num = mono[i].substring(0, mono[i].indexOf("/"));
                dum = mono[i].substring(mono[i].indexOf("/") + 1);
                this.monomials[i] = new Monomial(i, new RationalScalar(Integer.valueOf(num), Integer.valueOf(dum)));
            } else
                this.monomials[i] = new Monomial(i, new IntegerScalar(Integer.valueOf(mono[i])));
        }
    }

    public Polynomial(Monomial[] mono) {
        this.monomials = mono;
    }

    public static Polynomial build(String input) {
        String[] nums = new String[(input.length() / 2) + 1];
        int inx = 0;
        String str = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ') {
                str += c;
            }
            else {
                if (!str.equals(""))
                    nums[inx++] = str;
                str = "";
            }
        }
        if (!str.equals(""))
            nums[inx] = str;
        return new Polynomial(nums);
    }

    public Polynomial add(Polynomial p) {
        Monomial[] temp = new Monomial[Math.max(this.monomials.length, p.monomials.length)];
        for (int i = 0; i < this.monomials.length; i++) {
            if (i < p.monomials.length) {
                temp[i] = this.monomials[i].add(p.monomials[i]);
            }
        }
        return new Polynomial(temp);
    }

    public Polynomial mul(Polynomial p) {
        Monomial[] temp = new Monomial[this.monomials.length * p.monomials.length];
        for (int i = 0; i < this.monomials.length; i++) {
            for (int j = 0; j < p.monomials.length; j++) {
                if (temp[i + j] != null)
                    temp[i + j] = temp[i + j].add(this.monomials[i].mul(p.monomials[j]));
                else
                    temp[i + j] = this.monomials[i].mul(p.monomials[j]);
            }
        }
        Monomial[] temp2 = new Monomial[temp.length];
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] != null) {
                temp2 = new Monomial[i + 1];
                break;
            }
        }
        System.arraycopy(temp, 0, temp2, 0, temp2.length);
        return new Polynomial(temp2);
    }

    public Scalar evaluate(Scalar s) {
        Scalar sum = new RationalScalar(0, 1);
        for (Monomial monomial : this.monomials) {
            sum = sum.add(monomial.evaluate(s));
        }
        return sum;
    }

    public Polynomial derivative() {
        Monomial[] temp = new Monomial[this.monomials.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = this.monomials[i].derivative();
        }
        return new Polynomial(temp);
    }

    public boolean equals(Object o) {
        if (o instanceof Polynomial p) {
            if (this.monomials.length != p.monomials.length)
                return false;
            for (int i = 0; i < this.monomials.length; i++) {
                if (!this.monomials[i].equals(p.monomials[i]))
                    return false;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.monomials.length; i++) {
            if (this.monomials[i] != null) {
                if (!this.monomials[i].toString().equals("0")) {
                    str += this.monomials[i].toString();
                    if (i != this.monomials.length - 1)
                        str += " + ";
                }
            }
        }
        return str;
    }
}
