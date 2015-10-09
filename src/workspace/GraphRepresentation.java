package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class GraphRepresentation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int v = in.nextInt(), e = in.nextInt();
        Graph graph = new Graph(v);
        while(e-- > 0) {
            addEdge(graph, in.nextInt(), in.nextInt());
        }

        printGraph(graph);
    }

    void addEdge(Graph graph, int src, int dest) {
        AdjList list = graph.array[src];
        Node newNode = new Node(dest);
        newNode.next = list.head;
        list.head = newNode;

        // undirected graph, edge is 2-way
        newNode = new Node(src);
        newNode.next = graph.array[dest].head;
        graph.array[dest].head = newNode;
    }

    void printGraph(Graph graph) {
        for(int i = 0; i < graph.V; ++i) {
            System.out.print(i);
            Node cur = graph.array[i].head;
            while(cur != null) {
                System.out.print("->" + cur.dest);
                cur = cur.next;
            }
            System.out.println();
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

    class Graph {
        int V;
        AdjList []array;

        public Graph(int v) {
            V = v;
            this.array = new AdjList[v];
            for(int i = 0; i < v; ++i)
                this.array[i] = new AdjList();
        }
    }
}
