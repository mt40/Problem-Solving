package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Objects;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_NITT2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []num = in.c();

        boolean a = true, b = true;
        if(num.length < 3) a = b = false;
        a = div4(num) && div9(num) && div7(num);
        b = div3(num) && div25(num) && div7(num);

        out.print(a? "Yes " : "No ");
        out.println(b? "Yes" : "No ");
    }

    int digit(char c) {
        return c - '0';
    }

    boolean div4(char []num) {
        int n = num.length;
        int x = digit(num[n - 2]) * 10 + digit(num[n - 1]);
        return x % 4 == 0;
    }

    boolean div25(char []num) {
        int n = num.length;
        int x = digit(num[n - 2]) * 10 + digit(num[n - 1]);
        return x % 25 == 0;
    }

    boolean div3(char []num) {
        int sum = 0;
        for(char c : num) sum += digit(c);
        return sum % 3 == 0;
    }

    boolean div9(char []num) {
        int sum = 0;
        for(char c : num) sum += digit(c);
        return sum % 9 == 0;
    }

    static int []seven = {1, 3, 2, 6, 4, 5};
    boolean div7(char []num) {
        int sum = 0, n = num.length;
        for(int i = 0; i < n; ++i)
            sum += digit(num[n - 1 - i]) * seven[i % 6];
        return sum % 7 == 0;
    }
}