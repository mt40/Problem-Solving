package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_13A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[1000];

        for(int i = 2; i < n; ++i) {
            int sum = 0;
            int k = n;
            while(k > 0) {
                sum += k % i;
                k /= i;
            }
            a[i] = sum;
        }

        int x = 0, y = n - 2;
        for(int i = 0; i < a.length; ++i)
            x += a[i];

        int k = gcd(x, y);
        out.printf("%d/%d\n", x / k, y / k);
    }

    int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
