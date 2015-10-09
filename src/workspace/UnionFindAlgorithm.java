package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class UnionFindAlgorithm {
    /**
     * Union-Find algorithm to detect cycle in undirected graph
     * (you can use dfs, bfs instead though)
     * http://www.geeksforgeeks.org/union-find/
     * http://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int v = in.nextInt(), e = in.nextInt();
        Graph graph = new Graph(v);
        for(int i = 0; i < e; ++i)
            addEdge(graph, in.nextInt(), in.nextInt());

        out.println(hasCycle(graph));
    }

    boolean hasCycle(Graph graph) {
        Subset []subsets = new Subset[graph.V];
        boolean [][]visit = new boolean[graph.V][graph.V];
        for(int i = 0; i < graph.V; ++i) subsets[i] = new Subset(i);

        // loop for every edge
        for(int i = 0; i < graph.V; ++i) {
            Node cur = graph.array[i].head;
            while(cur != null) {
                if(!visit[i][cur.dest]) {
                    visit[i][cur.dest] = visit[cur.dest][i] = true;
                    int p_src = find(subsets, i);
                    int p_dest = find(subsets, cur.dest);
                    if (p_dest == p_src) {
                        System.out.printf("Back edge is: %d-%d\n", i, cur.dest);
                        return true; // in the same subset -> cycle detected!
                    }
                    union(subsets, p_src, p_dest);
                }
                cur = cur.next;
            }
        }
        return false;
    }

    // find the parent of subset contains v
    int find(Subset []subsets, int v) {
        if(subsets[v].parent != v)
            subsets[v].parent = find(subsets, subsets[v].parent); // path compression
        return subsets[v].parent;
    }

    // union 2 subsets, use Union by Rank (or height)
    void union(Subset []subsets, int x, int y) {
        int p_x = find(subsets, x);
        int p_y = find(subsets, y);

        if(subsets[p_x].rank < subsets[p_y].rank)
            subsets[p_x].parent = p_y;
        else if(subsets[p_y].rank < subsets[p_x].rank)
            subsets[p_y].parent = p_x;
        else { // equal rank
            subsets[p_x].parent = p_y;
            subsets[p_y].rank++;
        }
    }

    void addEdge(Graph graph, int src, int dest) {
        Node newNode = new Node(dest);
        newNode.next = graph.array[src].head;
        graph.array[src].head = newNode;

        newNode = new Node(src);
        newNode.next = graph.array[dest].head;
        graph.array[dest].head = newNode;
    }

    class Subset{
        int parent, rank;

        public Subset(int parent) {
            this.parent = parent;
        }
    }

    class Graph {
        int V;
        AdjList []array;

        public Graph(int v) {
            V = v;
            array = new AdjList[v];
            for(int i = 0; i < v; ++i) array[i] = new AdjList();
        }

        public String toString() {
            String rs = "";
            for(int i = 0; i < V; ++i) {
                rs += i;
                Node cur = array[i].head;
                while(cur != null) {
                    rs += "->" + cur.dest;
                    cur = cur.next;
                }
                rs += "\n";
            }
            return rs;
        }
    }

    class Node {
        int dest;
        Node next;

        public Node(int dest) {
            this.dest = dest;
        }
    }

    class AdjList {
        Node head;
    }
}
