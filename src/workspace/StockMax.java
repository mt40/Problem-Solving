package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class StockMax {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        // It's easier to buy stock when u know the future
        // so go backward
        int []doBuy = new int[n]; // 0: buy, 1: sell
        long profit = 0;
        int max = 0;
        for(int i = n - 1; i >= 0; --i) {
            int price = a[i];
            if (a[i] >= max) {
                doBuy[i] = 1;
                max = a[i];
            }
            profit += max - price;
        }

        out.println(profit);
    }
}
