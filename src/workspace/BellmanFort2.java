package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BellmanFort2 {
    /**
     * Bellman Fort shorted path algorithm with Adjacent list
     * Note that this implementation is for directed graph.
     * For undirected, remember to mark visited node to avoid
     * travelling on back-edge
     * http://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-algorithm/
     */
    final int INF = 1000000;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int v = in.nextInt(), e = in.nextInt();
        Graph graph = new Graph(v);
        for(int i = 0; i < e; ++i)
            addEdge(graph, in.nextInt(), in.nextInt(), in.nextInt());

        runBellmanFord(graph, 1);
    }

    void runBellmanFord(Graph graph, int src) {
        int V = graph.V;
        int []dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // loop V - 1 times
        for(int iii = 0; iii < V - 1; ++iii) {
            // loop each edge
            for(int i = 0; i < V; ++i) {
                Edge e = graph.array[i].head;
                while(e != null) {
                    int u = i, v = e.dest;
                    if(dist[u] + e.weight < dist[v])
                        dist[v] = dist[u] + e.weight;
                    e = e.next;
                }
            }
        }

        printDist(dist);
        /* Uncomment to check for negative cycle */
        if(negativeCycle(graph, dist))
            System.out.println("This graph has negative cycle!");
    }

    boolean negativeCycle(Graph graph, int []dist) {
        int V = graph.V;
        for(int i = 0; i < V; ++i) {
            Edge e = graph.array[i].head;
            while(e != null) {
                int u = i, v = e.dest;
                if(dist[u] + e.weight < dist[v])
                    return true;
                e = e.next;
            }
        }
        return false;
    }

    void printDist(int []dist) {
        System.out.println("Vertex   Distance from source");
        for(int i = 0; i < dist.length; ++i) {
            System.out.printf("%d\t\t %s\n", i, (dist[i] == INF) ? "INF" : dist[i]);
        }
    }

    void addEdge(Graph graph, int src, int dest, int weight) {
        Edge newNode = new Edge(weight, dest);
        newNode.next = graph.array[src].head;
        graph.array[src].head = newNode;

//        newNode = new Edge(weight, src);
//        newNode.next = graph.array[dest].head;
//        graph.array[dest].head = newNode;
    }

    class Graph {
        int V;
        AdjList []array;

        public Graph(int v) {
            V = v;
            array = new AdjList[v];
            for(int i = 0; i < v; ++i) array[i] = new AdjList();
        }
    }

    class Edge {
        int weight, dest;
        Edge next;

        public Edge(int weight, int dest) {
            this.weight = weight;
            this.dest = dest;
        }
    }

    class AdjList {
        Edge head;
    }
}
