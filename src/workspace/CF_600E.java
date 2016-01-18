package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_600E {
    long []ans;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] colors = new int[n];
        ans = new long[n];
        for (int i = 0; i < n; ++i) colors[i] = in.nextInt();
        Tree tree = new Tree(n, colors);

        for (int i = 0; i < n - 1; ++i) {
            int src = in.nextInt(), dest = in.nextInt();
            tree.addEdge(src - 1, dest - 1);
        }

        dfs(tree.root, new boolean[n]);

        for(long v : ans) {
            out.print(v + " ");
        }
    }

    Counter dfs(Node cur, boolean []visited) {
        visited[cur.id] = true;
        Counter cnt = new Counter();
        cnt.add(cur.color, 1);
        for (Node c : cur.children.values()) {
            if(visited[c.id]) continue;
            Counter rs = dfs(c, visited);
            if(rs.f.size() > cnt.f.size())
                cnt = rs.merge(cnt);
            else
                cnt = cnt.merge(rs);
        }
        //System.out.printf("%d: %s\n", cur.id + 1, Arrays.toString(cnt.tops.toArray()));
        ans[cur.id] = cnt.sum;
        return cnt;
    }

    class Counter {
        Map<Integer, Integer> f = new HashMap<>();
        long max = 0, sum = 0;
        List<Integer> tops = new ArrayList<>();

        void add(int key, int amt) {
            if (f.containsKey(key))
                f.put(key, f.get(key) + amt);
            else
                f.put(key, amt);
            int val = f.get(key);
            if (val == max) {
                tops.add(key);
                sum += key;
            }
            else if (val > max) {
                max = val;
                tops.clear();
                tops.add(key);
                sum = key;
            }
        }

        Counter merge(Counter other) {
            for (Map.Entry<Integer, Integer> e : other.f.entrySet()) {
                add(e.getKey(), e.getValue());
            }
            return this;
        }
    }

    class Node {
        int id, color;
        Map<Integer, Node> children = new HashMap<>();

        public Node(int id, int color) {
            this.id = id;
            this.color = color;
        }
    }

    class Tree {
        Node[] nodes;
        Node root;

        Tree(int n, int[] colors) {
            nodes = new Node[n];
            for (int i = 0; i < n; ++i)
                nodes[i] = new Node(i, colors[i]);
            root = nodes[0];
        }

        void addEdge(int src, int dest) {
            nodes[src].children.put(dest, nodes[dest]);
            nodes[dest].children.put(src, nodes[src]);
        }
    }
}
