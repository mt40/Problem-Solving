package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BigIntegerImplementation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String a = in.next(), b = in.next();

        BigInt x = new BigInt(a), y = new BigInt(b);
        out.println(x.add(y));
//        out.println(x.subtract(y));
        out.println(x.multiply(y));
//        out.println(x.divide(y));
    }

    class BigInt {
        public char[] num;
        int BASE = 10;

        public BigInt(String s) {
            num = new StringBuilder(s).reverse().toString().toCharArray();
        }

        int toInt(char c) {
            return c - '0';
        }

        char toChar(int i) {
            return (char)('0' + i);
        }

        boolean isZero() {
            return num.length == 1 && num[0] == '0';
        }

        @Override
        public String toString() {
            return new StringBuilder(String.valueOf(num)).reverse().toString();
        }

        public BigInt add(BigInt b) {
            if(isZero()) return b;
            if(b.isZero()) return this;

            int carry = 0, n = Math.max(num.length, b.num.length);
            char []rs = new char[n + 1];
            Arrays.fill(rs, ' ');
            for(int i = 0; i < n; ++i) {
                int a_i = (i >= num.length) ? 0 : toInt(num[i]);
                int b_i = (i >= b.num.length) ? 0 : toInt(b.num[i]);
                int sum = a_i + b_i + carry;
                carry = 0;
                if(sum >= BASE)
                    carry = 1;
                rs[n - i] = toChar(sum % 10);
            }
            if(carry > 0)
                rs[0] = toChar(carry);
            return new BigInt(String.valueOf(rs).trim());
        }

        public BigInt multiply(BigInt b) {
            int n = b.num.length;
            BigInt rs = new BigInt("0");
            for(int i = 0; i < n; ++i) {
                BigInt partial = multiply(toInt(b.num[i]));
                partial = partial.shiftLeft(i);
                rs = rs.add(partial);
            }
            return rs;
        }

        public BigInt multiply(int d) {
            if(d == 0) return new BigInt("0");
            int carry = 0, n = num.length;
            char []rs = new char[n + 1];
            Arrays.fill(rs, ' ');
            for(int i = 0; i < n; ++i) {
                int p = d * toInt(num[i]) + carry;
                carry = 0;
                if(p >= BASE)
                    carry = p / 10;
                rs[n - i] = toChar(p % 10);
            }
            if(carry > 0)
                rs[0] = toChar(carry);
            return new BigInt(String.valueOf(rs).trim());
        }

        // Shift left here means multiply by 10
        public BigInt shiftLeft(int amt) {
            String s = toString();
            while(amt-- > 0)
                s += '0';
            return new BigInt(s);
        }
    }
}
