package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class SPOJ_FISHER {
    int n, t, dest, minToll;
    int[][] time, toll;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        while (true) {
            n = in.nextInt();
            t = in.nextInt();
            dest = n - 1;
            minToll = -1;

            if (n == 0) return; // end

            time = new int[n][n];
            toll = new int[n][n];

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    time[i][j] = in.nextInt();
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    toll[i][j] = in.nextInt();

            /*
            * Tuy dùng Bellman nhưng tư tưởng là DP
            * dist[i][j] = minimum cost khi đi từ 0 -> đỉnh i và tốn thời gian là j
             */
            long[][] dist = new long[n][1001];
            for (long[] arr : dist)
                Arrays.fill(arr, Integer.MAX_VALUE);
            dist[0][0] = 0;

            // loop for time
            for(int i = 1; i <= 1000; ++i) {
                // loop for edges
                for(int v = 0; v < n; ++v) {
                    dist[v][i] = dist[v][i - 1]; // not go to any edge
                    for(int u = 0; u < n; ++u) {
                        if(i - time[u][v] >= 0) {
                            dist[v][i] = Math.min(dist[u][i - time[u][v]] + toll[u][v], dist[v][i]);
                        }
                    }
                }
            }

            // output
            long min = Integer.MAX_VALUE;
            int _time = 0;
            for (int i = 0; i <= t; ++i)
                if (dist[n - 1][i] > 0 && dist[n - 1][i] < min) {
                    min = dist[n - 1][i];
                    _time = i;
                }

            out.println(min + " " + _time);
        }
    }
}
