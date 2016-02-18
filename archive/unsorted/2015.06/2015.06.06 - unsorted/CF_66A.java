package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_66A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();

        out.println(cal(s));
    }

    String cal(String s) {
        if(inRange(s, "-128", "127"))
            return "byte";
        if(inRange(s, "-32768", "32767"))
            return "short";
        if(inRange(s, "-?2147483648", "2147483647"))
            return "int";
        if(inRange(s, "-9223372036854775808", "9223372036854775807"))
            return "long";
        return "BigInteger";
    }

    int compare(String a, String b) {
        if(a.length() < b.length())
            return -1;
        if(a.length() > b.length())
            return 1;
        return a.compareTo(b);
    }

    boolean inRange(String s, String low, String hi) {
        boolean left = false, right = false;
        if(s.charAt(0) == '-') {
            s = s.substring(1);
        }
        if(low.charAt(0) == '-') {
            low = low.substring(0);
        }
        left = compare(s, low) <= 0;
        right = compare(s, hi) <= 0;
        return left && right;
    }
}
