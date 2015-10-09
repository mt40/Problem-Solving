package workspace;

import java.util.*;
import java.io.PrintWriter;

public class GraphIsBipartite {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int v = in.nextInt(), e = in.nextInt();
        Graph graph = new Graph(v);
        for(int i = 0; i < e; ++i) {
            addEdge(graph, in.nextInt(), in.nextInt());
        }

        out.println(isBipartite(graph));
    }

    /**
     * Bipartite check using BFS
     */
    boolean isBipartite(Graph graph) {
        Map<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        colorMap.put(0, 0); // node 0 is colored 0
        while(q.size() > 0) {
            int x = q.poll();
            visited.add(x);
            int color = colorMap.get(x);
            AdjNode cur = graph.array[x].head;
            while(cur != null) {
                if(!visited.contains(cur.dest)) {
                    if (colorMap.containsKey(cur.dest) && colorMap.get(cur.dest) == color)
                        return false;
                    q.add(cur.dest);
                    colorMap.put(cur.dest, 1 - color);
                }
                cur = cur.next;
            }
        }
        if(visited.size() < graph.V)
            return false; // not connected graph
        return true;
    }

    void addEdge(Graph graph, int src, int dest) {
        AdjNode newNode = new AdjNode(dest);
        newNode.next = graph.array[src].head;
        graph.array[src].head = newNode;

        newNode = new AdjNode(src);
        newNode.next = graph.array[dest].head;
        graph.array[dest].head = newNode;
    }

    class Graph {
        int V;
        AdjList []array;

        public Graph(int v) {
            V = v;
            array = new AdjList[v];
            for(int i = 0; i < v; ++i)
                array[i] = new AdjList();
        }
    }

    class AdjNode {
        int dest;
        AdjNode next;

        public AdjNode(int dest) {
            this.dest = dest;
        }
    }

    class AdjList {
        AdjNode head;
    }
}
