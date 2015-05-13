package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class Fast_case_change {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char []a = in.next().toCharArray();
        int n = a.length;

        String lower = String.valueOf(toLowerCase(a.clone()));
        String upper = String.valueOf(toUpperCase(a.clone()));
        String switched = String.valueOf(switchCase(a.clone()));

        out.printf("lower-case: %s\n", lower);
        out.printf("upper-case: %s\n", upper);
        out.printf("switched-case: %s\n", switched);
    }

    char[] toLowerCase(char []arr) {
        for(int i = 0; i < arr.length; ++i)
            arr[i] |= ' ';
        return arr;
    }

    char[] toUpperCase(char []arr) {
        for(int i = 0; i < arr.length; ++i)
            arr[i] &= (arr[i] ^ ' ');
        return arr;
    }

    char[] switchCase(char []arr) {
        for(int i = 0; i < arr.length; ++i)
            arr[i] ^= ' ';
        return arr;
    }
}
