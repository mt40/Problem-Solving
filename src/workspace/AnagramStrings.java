package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class AnagramStrings {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String a = in.nextLine();
        String b = in.nextLine();

        boolean rs = isAnagram(a, b);
        if(rs)
            out.println("YES");
        else
            out.println("NO");
    }

    boolean isAnagram(String a, String b) {
        int rs = 0;
        for(int i = 0; i < a.length(); ++i) {
            rs ^= (int)a.charAt(i) ^ (int)b.charAt(i);
        }

        return (rs == 0) ? true : false;
    }

}
