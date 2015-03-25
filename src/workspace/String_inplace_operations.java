package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class String_inplace_operations {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();

        out.println("no duplicate: " + removeDuplicate(s));
    }

    // remove duplicates (in place)
    String removeDuplicate(String s) {
        char []a = s.toCharArray();
        Arrays.sort(a);

        char prev = a[0];
        String rs = "" + a[0];

        for(int i = 1; i < s.length(); ++i)
            if(a[i] != prev) {
                rs += a[i];
                prev = a[i];
            }

        return rs;
    }

}
