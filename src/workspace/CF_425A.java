package workspace;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_425A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                int []inside = Arrays.copyOfRange(a, i, j + 1);
                if(inside.length < n) {
                    PriorityQueue<Integer> outside = new PriorityQueue<Integer>(n - inside.length, Collections.reverseOrder());
                    for (int h = 0; h < n; ++h) {
                        if (h < i || h > j) {
                            outside.add(a[h]);
                        }
                    }

                    Arrays.sort(inside);

                    for (int h = 0; h < k && h < inside.length; ++h) {
                        if (inside[h] < outside.peek()) {
                            int tmp = inside[h];
                            inside[h] = outside.poll();
                            outside.add(tmp);
                        }
                    }
                }

                int sum = 0;
                for(int e : inside) {
                    sum += e;
                }
                ans = Math.max(sum, ans);
            }
        }

        out.println(ans);
    }
}
