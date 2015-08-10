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
        CF_56A solver = new CF_56A();
        solver.solve(1, in, out);
        out.close();
    }

    static class CF_56A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String[] drinks = {"ABSINTH", "BEER", "BRANDY", "CHAMPAGNE", "GIN", "RUM", "SAKE", "TEQUILA", "VODKA", "WHISKEY", "WINE"};
            int n = in.nextInt();
            int count = 0;
            for (int i = 0; i < n; ++i) {
                String s = in.next();
                if (find(drinks, s) >= 0) {
                    count++;
                } else if (Character.isDigit(s.charAt(0)) && Integer.valueOf(s) < 18) {
                    count++;
                }
            }
            out.println(count);
        }

        int find(String[] arr, String s) {
            for (int i = 0; i < arr.length; ++i) {
                String a = arr[i];
                if (a.compareTo(s) == 0)
                    return i;
            }
            return -1;
        }

    }
}

