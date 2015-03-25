package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ASCII_and_Integer {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt(); // t = 0: to ASCII, t = 1: to Int

        if(t == 0) {
            int i = in.nextInt();
            char rs = itoa(i);
            out.println(rs + " " + ((Object) rs).getClass().getName());
        }
        else {
            char a = in.next().charAt(0);
            int rs = atoi(a);
            out.println(rs + " " + ((Object)rs).getClass().getName());
        }
    }

    char itoa(int i) {
        return (char)((int)'0' + i);
    }

    int atoi(char a) {
        return (int)a - (int)'0';
    }
}
