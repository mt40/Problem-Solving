package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;

/*
*   This is a right solution but JAVA is to slow
*   to get AC, convert into C++
 */
public class CF_469C {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();

        if (n > 3) {
            String ans = "YES\n";
            // solution for n = 4
            String ans4 = "1 * 2 = 2\n" +
                    "3 * 4 = 12\n" +
                    "2 * 12 = 24\n";
            String ans5 = "5 - 3 = 2\n" +
                    "2 + 1 = 3\n" +
                    "2 * 4 = 8\n" +
                    "8 * 3 = 24\n";

            if ((n - 4) % 2 == 0) {
                ans += ans4;
                System.out.print(ans);
                for (int i = 5; i <= n - 1; i += 2)
                    System.out.printf("%d - %d = %d\n", i + 1, i, 1);
                for (int i = 0; i < (n - 4) / 2; ++i)
                    System.out.print("24 * 1 = 24\n");
            } else {
                ans += ans5;
                System.out.print(ans);
                for (int i = 6; i <= n - 1; i += 2)
                    System.out.printf("%d - %d = %d\n", i + 1, i, 1);
                for (int i = 0; i < (n - 5) / 2; ++i)
                    System.out.print("24 * 1 = 24\n");
            }
        }
        else {
            System.out.println("NO");
        }
    }
}
