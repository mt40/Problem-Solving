package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_12B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String a = in.next();
        String b = in.next();

        char []c = a.toCharArray();
        int n = c.length;
        Arrays.sort(c);
        String sorted = "";
        if(c[0] == '0') {
            for(int i = 0; i < n; ++i) {
                if(c[i] != '0') {
                    sorted += c[i];
                    c[i] = '-'; // mark as removed
                    break;
                }
            }
        }
        for(int i = 0; i < n; ++i) {
            if(c[i] != '-')
                sorted += c[i];
        }
        if(sorted.compareTo(b) == 0) {
            out.println("OK");
        }
        else {
            out.println("WRONG_ANSWER");
        }
    }
}
