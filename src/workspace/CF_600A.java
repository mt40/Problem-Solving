package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_600A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        String []parts = s.split(",|;", -1);
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        boolean a_added = false, b_added = false;
        for(String p : parts) {
            if(isNumber(p)) {
                a.append(a_added ? "," : "").append(p);
                a_added = true;
            }
            else {
                b.append(b_added ? "," : "").append(p);
                b_added = true;
            }
        }

        out.println(a_added ? String.format("\"%s\"", a.toString()) : "-");
        out.println(b_added ? String.format("\"%s\"", b.toString()) : "-");
    }

    boolean isNumber(String s) {
        if(s.length() == 0) return false;
        if(s.charAt(0) == '0' && s.length() > 1) return false;
        for(char c : s.toCharArray()) {
            if(!Character.isDigit((Character)c))
                return false;
        }
        return true;
    }
}
