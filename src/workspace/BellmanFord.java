package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BellmanFord {
    final int INF = Integer.MAX_VALUE; // infinite
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int V = in.nextInt();
        int [][]graph = new int[V + 1][V + 1];
        for(int i = 1; i <= V; ++i)
            for(int j = 1; j <= V; ++j)
                graph[i][j] = in.nextInt();

        int []dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // calculate shortest distance
        for(int i = 0; i < V - 1; ++i) { // do V - 1 times
            // loop through edges
            for(int u = 1; u <= V; ++u) {
                for(int v = 1; v <= V; ++v) {
                    if(graph[u][v] != 0) { // there is an edge
                        if(dist[v] > dist[u] + graph[u][v])
                            dist[v] = dist[u] + graph[u][v]; // better path
                    }
                }
            }
        }

        // loop through edges again to check for negative circle
        for(int u = 1; u <= V; ++u) {
            for(int v = 1; v <= V; ++v) {
                if(graph[u][v] != 0 && dist[v] > dist[u] + graph[u][v]) {
                    out.println("Graph has negative circle!");
                    v = V; // break
                    u = V;
                }
            }
        }

        for(int i = 1; i <= V; ++i)
            out.print(dist[i] + " ");
        out.println();
    }
}
