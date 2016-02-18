package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GSS5 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);
        long []cul = new long[n];
        for(int i = 0; i < n; ++i)
            cul[i] = (i > 0) ? cul[i - 1] + a[i] : a[i];
        int m = in.i();
        Query []queries = new Query[m];
        for(int i = 0; i < m; ++i)
            queries[i] = new Query(in.i()-1, in.i()-1, in.i()-1, in.i()-1);

        SegTree tree = new SegTree(a);
        StringBuilder sb = new StringBuilder();
        for(Query q : queries) {
            long ans;
            if(intersect(q)) {
                Node left = tree.get(new Query2(q.l1, q.l2));
                Node mid = tree.get(new Query2(q.l2 + 1, q.r1 - 1));
                Node right = tree.get(new Query2(q.r1, q.r2));
                if (mid != null)
                    ans = Util.max(mid.max, left.max_r, right.max_l,
                            left.max_r + mid.sum + right.max_l);
                else {
                    ans = Math.max(left.max_r, right.max_l);
                    if (q.l1 != q.l2 || q.r1 != q.r2)
                        ans = Math.max(ans, left.max_r + right.max_l);
                }
            }
            else {
                Node left = tree.get(new Query2(q.l1, q.r1));
                Node right = tree.get(new Query2(q.l2, q.r2));
                ans = left.max_r + sum(cul, q.r1 + 1, q.l2 - 1) + right.max_l;
            }

            sb.append(ans).append("\n");
        }

        out.print(sb.toString());
    }

    boolean intersect(Query q) {
        return !(q.r1 < q.l2);
    }

    long sum(long []cul, int l, int r) {
        if(r < l) return 0;
        if(l > 0) return cul[r] - cul[l - 1];
        return cul[r];
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

        Node get(Query2 q) {
            if(q.r < q.l) return null;
            return get(0, src.length - 1, q, 0);
        }

        Node get(int l, int r, Query2 q, int i) {
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

    class Query2 {
        int l, r;

        public Query2(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    class Query {
        int l1, r1, l2, r2;

        public Query(int l1, int r1, int l2, int r2) {
            this.l1 = l1;
            this.r1 = r1;
            this.l2 = l2;
            this.r2 = r2;
        }
    }
}