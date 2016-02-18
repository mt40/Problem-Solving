package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GSS3 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);
        int m = in.i();
        Query []queries = new Query[m];
        for(int i = 0; i < m; ++i)
            queries[i] = new Query(in.i(), in.i() - 1, in.i() - 1);

        SegTree tree = new SegTree(a);
        StringBuilder sb = new StringBuilder(); // faster
        for(Query q : queries) {
            if(q.t == 0)
                tree.update(q.l, q.r + 1);
            else {
                long ans = tree.get(q);
                sb.append(ans).append("\n");
            }
        }
        out.print(sb.toString());
    }

    class SegTree {
        Node []ar;
        int size;
        int []src;

        public SegTree(int []a) {
            int n = a.length;
            int h = (int)Math.ceil(Math.log(n) / Math.log(2));
            int size = (1 << (h + 1)) - 1;
            ar = new Node[size];

            src = a;
            build(0, n - 1, 0);
        }

        Node build(int l, int r, int i) {
            if(l == r)
                return ar[i] = new Node(src[l]);

            int m = (l + r) / 2;
            Node lchild = build(l, m, left(i));
            Node rchild = build(m + 1, r, right(i));
            ar[i] = merge(lchild, rchild);
            return ar[i];
        }

        void update(int id, int val) {
            update(0, src.length - 1, 0, id, val);
        }

        Node update(int l, int r, int i, int j, int val) {
            if(j < l || r < j) return ar[i]; // no update here, return old value

            if(l == r)
                return ar[i] = new Node(val);
            int m = (l + r) / 2;
            Node lchild = update(l, m, left(i), j, val);
            Node rchild = update(m + 1, r, right(i), j, val);
            ar[i] = merge(lchild, rchild);
            return ar[i];
        }

        long get(Query q) {
            Node rs = get(0, src.length - 1, q, 0);
            return (rs == null) ? -inf : rs.max;
        }

        Node get(int l, int r, Query q, int i) {
            if(q.r < l || r < q.l) return null;

            if(q.l <= l && r <= q.r) return ar[i];

            int m = (l + r) / 2;
            Node lchild = get(l, m, q, left(i));
            Node rchild = get(m + 1, r, q, right(i));
            return merge(lchild, rchild);
        }

        Node merge(Node lchild, Node rchild) {
            if(lchild == null) return rchild;
            if(rchild == null) return lchild;

            long max = Math.max(lchild.max, Math.max(rchild.max, lchild.max_r + rchild.max_l));
            Node rs = new Node(max);
            rs.max_l = Math.max(lchild.max_l, lchild.sum + rchild.max_l);
            rs.max_r = Util.max(rchild.max_r, lchild.max_r + rchild.sum);
            rs.sum = lchild.sum + rchild.sum;
            return rs;
        }

        int left(int i) {return (i << 1) + 1;}
        int right(int i) {return (i<<1) + 2;}
    }

    class Node {
        long max_l, max, sum, max_r;

        public Node(long val) {
            this.max_l = this.sum = this.max = this.max_r = val;
        }
    }

    class Query {
        int t, l, r;

        public Query(int t, int l, int r) {
            this.t = t;
            this.l = l;
            this.r = r;
        }
    }
}