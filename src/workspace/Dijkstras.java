package workspace;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class Dijkstras {
    /**
     * Dijkstra's Shortest Path algorithm for adjacent list graph
     */
    final int INF = 1000000;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int v = in.nextInt(), e = in.nextInt();
        Graph graph = new Graph(v);
        for(int i = 0; i < e; ++i) {
            addEdge(graph, in.nextInt(), in.nextInt(), in.nextInt());
        }

        runDijkstra(graph, 2);
    }

    void runDijkstra(Graph graph, int src) {
        int V = graph.V;
        //
        // stores vertices with its unprocessed distance
        int []dist = new int[V];
        // Shortest path set. Mark vertices that are processed
        boolean []sptSet = new boolean[V];
        // Initialize
        dist[src] = 0;
        for(int i = 0; i < V; ++i)
            if(i != src)
                dist[i] = INF;

        for(int i = 0; i < V; ++i) {
            int cur = getMin(dist, sptSet); // get the unprocessed vertex with smallest distance from src
            sptSet[cur] = true;
            Node edge = graph.array[cur].head;
            // begin visiting the adjacent vertices
            while(edge != null) {
                int dest = edge.dest;
                if(!sptSet[dest]) { // this vertex is not processed
                    if(dist[cur] + edge.weight < dist[dest])
                        dist[dest] = dist[cur] + edge.weight;
                }
                edge = edge.next;
            }
        }

        printDist(dist);
    }

    void printDist(int []dist) {
        System.out.println("Vertex   Distance from source");
        for(int i = 0; i < dist.length; ++i) {
            System.out.printf("%d\t\t %s\n", i, (dist[i] == INF) ? "INF" : dist[i]);
        }
    }

    int getMin(int []arr, boolean []sptSet) {
        int min = INF, min_id = -1;
        for(int i = 0; i < arr.length; ++i)
            if(arr[i] < min && !sptSet[i]) {
                min_id = i;
                min = arr[i];
            }
        return min_id;
    }

    void addEdge(Graph graph, int src, int dest, int weight) {
        Node newNode = new Node(weight, dest);
        newNode.next = graph.array[src].head;
        graph.array[src].head = newNode;

        newNode = new Node(weight, src);
        newNode.next = graph.array[dest].head;
        graph.array[dest].head = newNode;
    }

    class Graph {
        int V;
        AdjList []array;

        public Graph(int v) {
            V = v;
            array = new AdjList[V];
            for(int i = 0; i < v; ++i) array[i] = new AdjList();
        }
    }

    class Node {
        int weight, dest;
        Node next;

        public Node(int weight, int dest) {
            this.weight = weight;
            this.dest = dest;
        }
    }

    class AdjList {
        Node head;
    }
}
