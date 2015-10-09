import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author mthai
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CF_584A solver = new CF_584A();
        solver.solve(1, in, out);
        out.close();
    }

    static class CF_584A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt(), t = in.nextInt();
            String ans = "" + t;

            while (ans.length() < n)
                ans += '0';

            if (n == 1 && t == 10)
                out.println(-1);
            else
                out.println(ans);
        }

    }
}

