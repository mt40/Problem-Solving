package workspace;

import java.util.*;
import java.io.PrintWriter;

public class Dijkstra_K_ShortestPath {
    /**
     * Find the k shortest paths from source s to destination t
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int v = in.nextInt(), e = in.nextInt();
        int K = in.nextInt(), m = in.nextInt();
        Graph graph = new Graph(v, e);
        for(int i = 0; i < e; ++i)
            addEdge(graph, in.nextInt(), in.nextInt(), in.nextInt());

        while(m-- > 0) {
            int src = in.nextInt(), dest = in.nextInt();
            List<Path> shortest_paths = kShortestPaths(graph, src, dest, K);
            out.printf("Find from %d to %d\n", src, dest);
            for(Path p : shortest_paths)
                out.println(p);
            out.println();
        }
    }

    List<Path> kShortestPaths(Graph graph, int src, int dest, int K) {
        List<Path> P = new ArrayList();
        PriorityQueue<Path> B = new PriorityQueue<Path>(graph.E, pathCpr);
        int []path_count = new int[graph.V]; // count number of shortest paths found to each node
        B.add(new Path(new Edge(0, src))); // add edge src->src, cost = 0

        while(B.size() > 0 && path_count[dest] < K) {
            Path min = B.poll();
            int u = min.dest;
            path_count[u]++;
            if(u == dest)
                P.add(min);
            if(path_count[u] <= K) {
                // for each adjacent vertices
                Edge cur = graph.array[u].head;
                while(cur != null) {
                    Path newPath = new Path(min, cur);
                    B.add(newPath);
                    cur = cur.next;
                }
            }
        }

        return P;
    }

    Comparator<Path> pathCpr = new Comparator<Path>() {
        @Override
        public int compare(Path o1, Path o2) {
            return Integer.compare(o1.cost, o2.cost);
        }
    };

    class Path {
        List<Edge> trace;
        int cost, dest;

        public Path(Edge e) {
            trace = new ArrayList<Edge>();
            trace.add(e);
            cost = e.weight;
            dest = e.dest;
        }

        public Path(Path p, Edge e) {
            trace = new ArrayList<Edge>(p.trace); // shallow copy
            trace.add(e);
            cost = p.cost + e.weight;
            dest = e.dest;
        }

        @Override
        public String toString() {
            String l = "";
            for(Edge e : trace)
                l += e.dest + " ";
            return String.format("Cost: %d, Path: %s", cost, l);
        }
    }

    void addEdge(Graph graph, int src, int dest, int weight) {
        Edge newNode = new Edge(weight, dest);
        newNode.next = graph.array[src].head;
        graph.array[src].head = newNode;
    }

    class Graph {
        int V, E;
        AdjList []array;

        public Graph(int v, int e) {
            V = v;
            E = e;
            array = new AdjList[v];
            for(int i = 0; i < v; ++i)
                array[i] = new AdjList();
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
