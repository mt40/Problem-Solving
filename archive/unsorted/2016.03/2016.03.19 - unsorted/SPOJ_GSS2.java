package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GSS2 {
    int inf = Integer.MAX_VALUE;

    /**
     * Surrender! This problem is too difficult!
     * You can find the solution in the link though but it is too complex!
     * https://www.quora.com/How-can-the-SPOJ-problem-GSS2-be-solved/answer/Brian-Bi?srid=zQg0
     */
    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);
        int m = in.i();
        Query []queries = new Query[m];
        for(int i = 0; i < m; ++i)
            queries[i] = new Query(in.i()-1, in.i()-1, i);

        Arrays.sort(queries, (o1, o2) -> Integer.compare(o1.left, o2.left));

        HashMap<Integer, Queue<Integer>> next = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            if(!next.containsKey(a[i]))
                next.put(a[i], new LinkedList<>());
            else {
                next.get(a[i]).add(i);
                a[i] = 0;
            }
        }

        SegTree tree = new SegTree(a, n);
        long []results = new long[m];

        for(int i = 0, j = 0; i < n; ++i) {
            while(j < m && queries[j].left == i) {
                Query q = queries[j];
                long rs = tree.rangeSum(q.left, q.right);
                rs = Math.max(0, rs);
                results[q.idx] = rs;
                j++;
            }

            // recover the next duplicate element to its original value
            if(next.containsKey(a[i]) && !next.get(a[i]).isEmpty()) {
                int nextIdx = next.get(a[i]).poll();
                tree.set(nextIdx, a[i]);
                a[nextIdx] = a[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; ++i)
            sb.append(results[i]).append("\n");
        out.print(sb);
    }

    private class SegTree {
        Node []tree;
        int size;
        int []src;

        SegTree(int []src, int n) {
            int h = (int)Math.ceil(Math.log(n)/Math.log(2));
            size = (1 << (h + 1)) - 1;
            tree = new Node[size];
            for(int i = 0; i < size; ++i)
                tree[i] = new Node();
            this.src = src;
            build(0, n-1, 0);
        }

        Node build(int l, int r, int cur) {
            if(l == r)
                return tree[cur] = new Node(src[l]);
            int mid = (l + r) / 2;
            Node left = build(l, mid, leftChild(cur));
            Node right = build(mid + 1, r, rightChild(cur));
            return tree[cur] = merge(left, right, tree[cur]);
        }

        long rangeSum(int l, int r) {
            return rangeSum(0, src.length-1, l, r, 0).max;
        }

        void set(int idx, int val) {
            set(0, src.length-1, idx, val, 0);
        }

        Node rangeSum(int l, int r, int ql, int qr, int cur) {
            if(qr < l || r < ql)
                return new Node();
            if(ql <= l && r <= qr)
                return tree[cur];
            int mid = (l + r) / 2;
            Node left = rangeSum(l, mid, ql, qr, leftChild(cur));
            Node right = rangeSum(mid + 1, r, ql, qr, rightChild(cur));
            return merge(left, right, new Node());
        }

        Node set(int l, int r, int idx, int val, int cur) {
            if(idx < l || r < idx) return new Node();

            if(l == r)
                return tree[cur] = new Node(val);
            int mid = (l + r) / 2;
            Node left = set(l, mid, idx, val, leftChild(cur));
            Node right = set(mid + 1, r, idx, val, rightChild(cur));
            return tree[cur] = merge(left, right, tree[cur]);
        }

        Node merge(Node left, Node right, Node mid) {
            mid.max = Util.max(left.max, right.max, left.right + right.left);
            mid.left = Math.max(left.left, left.sum + right.left);
            mid.right = Math.max(right.right, right.sum + left.right);
            mid.sum = left.sum + right.sum;
            return mid;
        }

        int leftChild(int i) {
            return (i << 1) + 1;
        }

        int rightChild(int i) {
            return (i << 1) + 2;
        }
    }

    class Node {
        long left, right, max, sum;

        Node() {}

        Node(long max) {
            this.max = left = right = sum = max;
        }
    }

    private class Query {
        int left, right, idx;

        Query(int left, int right, int idx) {
            this.left = left;
            this.right = right;
            this.idx = idx;
        }
    }
}