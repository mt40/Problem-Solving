package workspace;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class temp {
    BigInteger one = BigInteger.ONE;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = 1;
        BigInteger cur = BigInteger.valueOf(70);
        while(n <= 250) {
            do {
                cur = cur.add(one);
            } while(!check(cur));
            n++;
            System.out.printf("%d. %d - %d\n", n, cur, cur.multiply(cur));
        }
    }

    boolean check(BigInteger x) {
        x = x.multiply(x);
        char []a = x.toString().toCharArray();
        boolean []b = new boolean[10];
        for(char c : a) {
            b[c - '0'] = true;
            if(c != '0' && c != '4' && c != '9')
                return false;
        }
        return b[0] && b[4] && b[9];
    }
}
