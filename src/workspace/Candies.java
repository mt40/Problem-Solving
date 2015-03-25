package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Candies {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int[] candy = new int[n];
        Arrays.fill(candy, 1); // each one has at least 1 candy
        for(int i = 0; i + 1 < n; ++i)
            if(a[i] < a[i + 1])
                candy[i + 1] = Math.max(candy[i + 1], candy[i] + 1);

        for(int i = n - 1; i - 1 >= 0; --i)
            if(a[i - 1] > a[i])
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);

        //out.println(Arrays.toString(candy));
        out.println(sum(candy));
    }

    public long sum(int []a) {
        long sum = 0;
        for(int i = 0; i < a.length; ++i)
            sum += a[i];
        return sum;
    }
}
