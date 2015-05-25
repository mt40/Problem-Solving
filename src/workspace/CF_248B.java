package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_248B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int []rem = {0, 1, 10, 100, 160, 130, 40, 190};
        int id = n;
        if(id > 7) {
            id = (n - 1) % 6 + 1;
            if(id == 1)
                id = 7;
        }
        int rem_n = rem[id];
        int target = 210 - rem_n;

        String ans = "";
        if(n <= 2) {
            out.println(-1);
            return;
        }
        if(n == 3) {
            out.println(210);
            return;
        }
        else {
            for(int i = 0; i <= 9; ++i) {
                int remain = target - 100 * i;
                for(int j = 0; j <= 9; ++j)
                    if(10 * j == remain) {
                        ans = (i > 0) ? "" + i : "";
                        ans += "" + j + "0";
                        j = 10; i = 10;
                    }
            }
        }

        int pad = n - ans.length() - 1;
        out.print(1);
        for(int i = 0; i < pad; ++i)
            out.print(0);
        out.println(ans);
    }
}
