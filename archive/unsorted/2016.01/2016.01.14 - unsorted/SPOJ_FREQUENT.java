package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FREQUENT {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int m = in.i();

            int []a = in.arr(n);
            SegTree tree = new SegTree(a);
            //System.out.println(Arrays.toString(tree.st));
            while(m-- > 0) {
                int l = in.i() - 1, r = in.i() - 1;
                Node ans = tree.get(0, n - 1, l, r, 0);
                out.println(ans.a.f);
            }
        }
    }

    class SegTree {
        Node []st;

        SegTree(int []a) {
            int n = a.length;
            int h = (int)(Math.ceil(Math.log(n) / Math.log(2)));
            int size = (int)Math.pow(2, h + 1) - 1;
            st = new Node[size];

            init(a, 0, n - 1, 0);
        }

        Node get(int l, int r, int ql, int qr, int i) {
            if(l > r || qr < l || r < ql) return null;

            if(ql <= l && r <= qr) return st[i];

            int mid = (r + l) / 2;
            Node left = get(l, mid, ql, qr, left(i));
            Node right = get(mid + 1, r, ql, qr, right(i));
            if(left == null) return right;
            if(right == null) return left;
            return merge(left, right);
        }

        Node init(int []a, int l, int r, int i) {
            if(l == r) return st[i] = new Node(a[l]);

            int mid = (l + r) / 2;
            Node left = init(a, l, mid, left(i));
            Node right = init(a, mid + 1, r, right(i));

            /* merge */
            Node t = merge(left, right);
            return st[i] = t;
        }

        Node merge(Node left, Node right) {
            Node t = new Node();
            t.l = left.l.clone();
            t.r = right.r.clone();
            t.a = (left.a.f > right.a.f) ? left.a.clone() : right.a.clone();

            if(left.l.v == right.l.v)
                t.l.f = left.l.f + right.l.f;
            if(right.r.v == left.r.v)
                t.r.f = right.r.f + left.r.f;

            if(left.r.v == right.l.v && left.r.f + right.l.f > t.a.f)
                t.a = new Pair(left.r.v, left.r.f + right.l.f);

            return t;
        }

        int left(int i) {return i * 2 + 1;}
        int right(int i) {return i * 2 + 2;}
    }

    class Node {
        Pair l, r, a; // left, right, all

        Node() {
            l = new Pair(); r = new Pair(); a = new Pair();
        }

        Node (int v) {
            l = new Pair(v);
            r = new Pair(v);
            a = new Pair(v);
        }

        @Override
        public String toString() {
            return "" + a;
        }
    }

    class Pair {
        int v, f = 1;

        public Pair() {}

        public Pair clone() {
            return new Pair(v, f);
        }

        public Pair(int v) {
            this(v, 1);
        }

        public Pair(int v, int f) {
            this.v = v;
            this.f = f;
        }

        @Override
        public String toString() {
            return "{" +
                    "v=" + v +
                    ", f=" + f +
                    '}';
        }
    }
}