package workspace;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_580B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), d = in.nextInt();
        Pair []friends = new Pair[n];
        for(int i = 0; i < n; ++i) {
            friends[i] = new Pair(in.nextInt(), in.nextInt());
        }

        Arrays.sort(friends, cpr);

        long []sum = new long[n];
        for(int i = 0; i < n; ++i)
            sum[i] += (i > 0)? friends[i].B + sum[i - 1] : friends[i].B;

        long max = friends[0].B;
        int index = 1;
        for(int i = 0; i < n; ++i) {
//            int r = max_possible(friends, d, friends[i].A, i, n - 1);
//            long tmp = (i == 0)? sum[r] : sum[r] - sum[i - 1];
//            max = Math.max(max, tmp);
            while(index < n && friends[index].A - friends[i].A < d) {
                max = Math.max(max, (i == 0)? sum[index] : sum[index] - sum[i - 1]);
                index++;
            }
        }

        out.println(max);
    }

    Comparator cpr = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.A, o2.A);
        }
    };

    class Pair {
        int A, B;

        public Pair(int a, int b) {
            A = a;
            B = b;
        }
    }
}
