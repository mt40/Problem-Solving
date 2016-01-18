package workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_203C {
    int[] readArr(int n, Scanner in) { int []a = new int[n]; for(int i = 0; i < n; ++i) a[i] = in.nextInt(); return a; }
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), d = in.nextInt();
        int a = in.nextInt(), b = in.nextInt();
        Pair []p = new Pair[n];
        for(int i = 0; i < n; ++i) {
            int x = in.nextInt(), y = in.nextInt();
            p[i] = new Pair(i + 1, cost(x, y, a, b));
        }
        Arrays.sort(p);
        List<Integer> ans = new ArrayList<>();
        long total = 0; int i = 0;
        while(i < n) {
            if(total + p[i].cost <= d) {
                ans.add(p[i].id);
                total += p[i].cost;
            }
            if(total > d) break;
            i++;
        }

        out.println(ans.size());
        for(int x : ans)
            out.print(x + " ");
    }

    int cost(int x, int y, int a, int b) {
        return x * a + y * b;
    }

    class Pair implements Comparable<Pair> {
        int id, cost;

        public Pair(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(cost, o.cost);
        }
    }
}
