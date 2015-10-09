package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CycleDetect_TopologicalSort {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int e = in.nextInt(), v = in.nextInt();
        Graph graph = new Graph(e, v);
        for(int i = 0; i < e; ++i) {
            addEdge(graph, in.nextInt(), in.nextInt());
        }

        topo(graph);
    }

    void topo(Graph graph) {
        int E = graph.E, V = graph.V;
        boolean []visit = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> sorted = new ArrayList<Integer>();
        HashSet<Edge> marked_edges = new HashSet<Edge>();
        queue.add(0);
        while(queue.size() > 0) {
            int cur = queue.poll();
            if(visit[cur]) continue;
            sorted.add(cur);
            visit[cur] = true;
            Edge e = graph.array[cur].head;
            while(e != null) {
                if(!visit[e.dest]) {
                    queue.add(e.dest);
                    marked_edges.add(e);
                }
                e = e.next;
            }
        }

        boolean hasCycle = false;
        hasCycle = marked_edges.size() < E;
        if(hasCycle)
            System.out.println("Cycle detected!");
        System.out.print("Topology order: ");
        for(int i : sorted)
            System.out.print(i + " ");
        System.out.println();
    }

    void addEdge(Graph graph, int src, int dest) {
        Edge newNode = new Edge(dest);
        newNode.next = graph.array[src].head;
        graph.array[src].head = newNode;

//        newNode = new AdjNode(src);
//        newNode.next = graph.array[dest].head;
//        graph.array[dest].head = newNode;
    }

    class Graph {
        int E, V;
        AdjList []array;

        public Graph(int e, int v) {
            E = e;
            V = v;
            array = new AdjList[v];
            for(int i = 0; i < v; ++i)
                array[i] = new AdjList();
        }
    }

    class Edge {
        int dest;
        Edge next;

        public Edge(int dest) {
            this.dest = dest;
        }
    }

    class AdjList {
        Edge head;
    }
}
