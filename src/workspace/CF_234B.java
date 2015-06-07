package workspace;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_234B {
    final int INF = 1000000000;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        try {
            in = new Scanner(new FileReader("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"));
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i)
                a[i] = in.nextInt();

            for (int i = 0; i < n - k; ++i) {
                int pos = min(a);
                a[pos] = INF;
            }

            out.println(a[min(a)]);
            for (int i = 0; i < n; ++i) {
                if (a[i] < INF)
                    out.print((i + 1) + " ");
            }
            out.println();
        }catch (Exception e) {}
    }

    int min(int []a) {
        int rs = 0;
        for(int i = 1; i < a.length; ++i)
            if(a[i] < a[rs])
                rs = i;
        return rs;
    }
}
