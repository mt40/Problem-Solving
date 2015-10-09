package workspace;

import java.util.*;
import java.io.PrintWriter;

public class TreeDiameter {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Tree tree = new Tree();
        for(int i = 0; i < n; ++i) {
            char s = in.next().charAt(0), e = in.next().charAt(0);
            int w = in.nextInt();
            tree.add(s, e, w);
        }
        tree.calWeight(tree.root);
        calDiameter(tree.root);
        out.println(max_diameter);
    }

    int max_diameter = 0;

    void calDiameter(Node cur) {
        /* Case 1: the longest path go through here. It must go through the
        1st and 2nd largest weight children
         */
        if(cur.edges.size() > 1) {
            Collections.sort(cur.edges, cpr);
            int first = cur.edges.get(0).weight + cur.edges.get(0).dest.weight;
            int second = cur.edges.get(1).weight + cur.edges.get(1).dest.weight;
            max_diameter = Math.max(max_diameter, first + second);
        }
        /* Case 2: the path does not go through here, it must be in one of
        the children
         */
        for(Edge e : cur.edges)
            calDiameter(e.dest);
    }

    Comparator<Edge> cpr = new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            return Integer.compare(o2.weight + o2.dest.weight, o1.weight + o1.dest.weight);
        }
    };

    class Node {
        char value;
        int weight; // weight of the longest path from this to a leaf
        List<Edge> edges = new ArrayList<Edge>();

        public Node(char value) {
            this.value = value;
        }
    }

    class Edge {
        int weight;
        Node dest;

        public Edge(int weight, Node dest) {
            this.weight = weight;
            this.dest = dest;
        }
    }

    class Tree {
        Node root;
        Map<Character, Node> map = new HashMap<Character, Node>();

        void add(Character start, Character end, int weight) {
            if(root == null) {
                root = new Node(start);
                map.put(start, root);
            }
            Node cur = map.get(start);
            Node dest = new Node(end);
            cur.edges.add(new Edge(weight, dest));
            map.put(end, dest);
        }

        int calWeight(Node cur) {
            if(cur == null) return 0;
            cur.weight = 0;
            for(Edge e : cur.edges) {
                cur.weight = Math.max(cur.weight, e.weight + calWeight(e.dest));
            }
            return cur.weight;
        }
    }
}
