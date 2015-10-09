package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskSchedule {
    /**
     * Given a set T of tasks. Task T_i lasts t_i time.
     * T_i may or maynot have a set of prerequisite tasks
     * that must be completed before T_i.
     * Find the min time to complete all tasks
     * Tasks that are not related can be done at the same time.
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        boolean[][] graph = new boolean[n][n];
        int[] time = new int[n];
        for (int i = 0; i < n; ++i)
            time[i] = in.nextInt();
        while (m-- > 0) {
            int tmp = in.nextInt() - 1;
            int dest = in.nextInt();
            for (int i = 0; i < tmp; ++i) {
                int src = in.nextInt();
                graph[src][dest] = true; // add edge
                dest = src;
            }
        }

        out.println(cal(graph, time));
    }

    int cal(boolean[][] graph, int[] time) {
        int total = 0;
        boolean[] visit = new boolean[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (!visit[i])
                total = Math.max(cal(graph, time, visit, i), total);
        }
        return total;
    }

    // use dfs
    int cal(boolean[][] graph, int[] time, boolean[] visit, int v) {
        int n = graph.length, t = 0;
        visit[v] = true;
        for (int i = 0; i < n; ++i) {
            if (graph[v][i] && !visit[i]) {
                t = Math.max(cal(graph, time, visit, i), t);
            }
        }

        return time[v] + t;
    }
}
