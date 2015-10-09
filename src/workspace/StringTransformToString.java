package workspace;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class StringTransformToString {
    /**
     * Given a dictionary D, string A, B.
     * Find a sequence of transform A, A1, A2, ..., B
     * such that Ai belongs to D and Ai differ from Ai-1
     * and Ai+1 1 character
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Map<String, Integer> dict = new HashMap<String, Integer>();
        for(int i = 0; i < n; ++i)
            dict.put(in.next(), i);

        Graph graph = new Graph(100);
        Object []entries = dict.entrySet().toArray();
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
//                Map.Entry<String, Integer> x = (Map.Entry<String, Integer>)entries[i], y = (Map.Entry<String, Integer>)entries[j];
//                if(countDiff(x.getKey(), y.getKey()) == 1)
//                    addEdge(graph, x.getValue(), y.getValue());
            }
        }
        //TODO
    }

    void addEdge(Graph graph, int src, int dest) {
        Node newNode = new Node(dest);
        newNode.next = graph.array[src].head;
        graph.array[src].head = newNode;

        newNode = new Node(src);
        newNode.next = graph.array[dest].head;
        graph.array[dest].head = newNode;
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
            array = new AdjList[v];
            for(int i = 0; i < v; ++i)
                array[i] = new AdjList();
        }
    }
}
