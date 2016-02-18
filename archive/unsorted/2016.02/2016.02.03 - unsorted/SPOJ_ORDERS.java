package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ORDERS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        BTree tree = new BTree();
        for(int i = 1; i <= n; ++i) {
            Pair p = new Pair(i, a[i - 1]);
            tree.add(p);
        }

        int []map = tree.getResult();
        int []ans = new int[n + 1];
        for(int i = 0; i < map.length; ++i)
            ans[map[i]] = i + 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < ans.length; ++i)
            sb.append(ans[i]).append(" ");
        out.println(sb.toString());
    }

    class Pair {
        int v, i;

        public Pair(int v, int i) {
            this.v = v;
            this.i = i;
        }

        Pair reduce(int x) {
            i -= x;
            return this;
        }
    }

    class BTree {
        Node root;

        void add(Pair key) {
            if(root == null) root = new Node(key.v);
            else add(root, key);
        }

        Node add(Node cur, Pair key) {
            if(cur == null)
                return new Node(key.v);
            int right_size = (cur.r != null) ? cur.r.size + 1 : 1;
            if(key.i >= right_size)
                cur.l = add(cur.l, key.reduce(right_size));
            else
                cur.r = add(cur.r, key);
            cur.size++;
            return cur;
        }

        ArrayList<Integer> inorder = new ArrayList<>();
        void traverse(Node nd) {
            if(nd == null) return;
            traverse(nd.l);
            inorder.add(nd.num);
            traverse(nd.r);
        }

        int[] getResult() {
            traverse(root);
            int []rs = new int[inorder.size()];
            for(int i = 0; i < rs.length; ++i)
                rs[i] = inorder.get(i);
            return rs;
        }

        class Node {
            int num, size = 1;
            Node l, r;

            public Node(int num) {
                this.num = num;
            }
        }
    }
}