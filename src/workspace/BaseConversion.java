package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BaseConversion {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        int n = in.nextInt();
        int []base = new int[t];
        for(int i = 0; i < t; ++i)
            base[i] = in.nextInt();

        for(int i = 0; i < t; ++i) {
            out.println(decimalToBase(n, base[i]));
        }
    }

    String decimalToBase(int n, int base) {
        String rs = "";
        for(; n > 0; n /= base) {
            int mod = n % base;
            if(mod >= 10)
                rs = (char)(mod - 10 + 'A') + rs;
            else
                rs = "" + mod + rs;
        }
        return rs;
    }
}
