package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;

public class SPOJ_SEGSQRSS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), Q = in.i();
        int []a = in.arr(n);

        SegTree tree = new SegTree(a, n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; ++i) {
            int type = in.i(), l = in.i()-1, r = in.i()-1;
            if(type == 2) {
                long sum = tree.sum(l, r);
                sb.append(sum).append("\n");
            }
            else if(type == 1) {
                int addVal = in.i();
                tree.add(l, r, addVal);
            }
            else {
                int setVal = in.i();
                tree.set(l, r, setVal);
            }
        }

        out.printf("Case %d:\n", testNumber);
        out.print(sb);
    }

    class SegTree {
        Node []tree;
        Update []lazy;
        int size, srcLen;
        int []src;

        public SegTree(int []src, int len) {
            srcLen = len;
            this.src = src;
            int h = (int)Math.ceil(Math.log(len) / Math.log(2));
            int size = (1 << (h + 1)) - 1;
            tree = new Node[size];
            lazy = new Update[size];

            build(0, len - 1, 0);
        }

        Node build(int l, int r, int cur) {
            if(l == r)
                return tree[cur] = new Node(src[l]);
            int mid = (l + r) / 2;
            Node left = build(l, mid, leftChild(cur));
            Node right = build(mid + 1, r, rightChild(cur));
            tree[cur] = new Node(0);
            return merge(left, right, tree[cur]);
        }

        long sum(int ql, int qr) {
            return sum(0, srcLen - 1, ql, qr, 0);
        }

        long sum(int l, int r, int ql, int qr, int cur) {
            if(lazy[cur] != null)
                doPendingUpdate(l, r, cur);

            if(qr < l || r < ql)
                return 0;

            if(ql <= l && r <= qr)
                return tree[cur].square;

            int mid = (l + r) / 2;
            long left = sum(l, mid, ql, qr, leftChild(cur));
            long right = sum(mid + 1, r, ql, qr, rightChild(cur));
            return left + right;
        }

        void set(int ql, int qr, int val) {
            set(0, srcLen - 1, ql, qr, 0, val);
        }

        Node set(int l, int r, int ql, int qr, int cur, int val) {
            if(lazy[cur] != null) {
                doPendingUpdate(l, r, cur);
            }

            if (qr < l || r < ql)
                return tree[cur];

            int mid = (l + r) / 2;

            // completely in range
            if(ql <= l && r <= qr) {
                int len = r - l + 1;
                tree[cur].set(len, val);
                if(l < r) { // not leaf
                    setLazy(l, mid, leftChild(cur), new Update(0, val));
                    setLazy(mid + 1, r, rightChild(cur), new Update(0, val));
                }
                return tree[cur];
            }

            // partially in range
            Node left = set(l, mid, ql, qr, leftChild(cur), val);
            Node right = set(mid + 1, r, ql, qr, rightChild(cur), val);
            return merge(left, right, tree[cur]);
        }

        void add(int ql, int qr, int val) {
            add(0, srcLen - 1, ql, qr, 0, val);
        }

        Node add(int l, int r, int ql, int qr, int cur, int val) {
            if(lazy[cur] != null)
                doPendingUpdate(l, r, cur);

            if (qr < l || r < ql)
                return tree[cur];

            int mid = (l + r) / 2;

            if(ql <= l && r <= qr) {
                tree[cur].add(r - l + 1, val);
                if(l < r) { // not leaf
                    setLazy(l, mid, leftChild(cur), new Update(1, val));
                    setLazy(mid + 1, r, rightChild(cur), new Update(1, val));
                }
                return tree[cur];
            }

            Node left = add(l, mid, ql, qr, leftChild(cur), val);
            Node right = add(mid + 1, r, ql, qr, rightChild(cur), val);
            return merge(left, right, tree[cur]);
        }

        void setLazy(int l, int r, int cur, Update up) {
            if(lazy[cur] != null)
                doPendingUpdate(l, r, cur);
            lazy[cur] = up;
        }

        void doPendingUpdate(int l, int r, int cur) {
            Update up = lazy[cur];
            if(up.type == 0)
                tree[cur].set(r - l + 1, up.value);
            else
                tree[cur].add(r - l + 1, up.value);

            if(l < r) {
                int mid = (l + r) / 2;
                setLazy(l, mid, leftChild(cur), lazy[cur]);
                setLazy(mid + 1, r, rightChild(cur), lazy[cur]);
            }
            lazy[cur] = null; // done
        }

        Node merge(Node left, Node right, Node mid) {
            mid.sum = left.sum + right.sum;
            mid.square = left.square + right.square;
            return mid;
        }

        int leftChild(int i) {
            return i * 2 + 1;
        }

        int rightChild(int i) {
            return i * 2 + 2;
        }

        class Update {
            int type; // 0 for set, 1 for add
            long value;

            public Update(int type, long value) {
                this.type = type;
                this.value = value;
            }
        }
    }

    class Node {
        long sum, square;

        public Node(long val) {
            set(1, val);
        }

        void set(int len, long value) {
            this.sum = len * value;
            this.square = len * value * value;
        }

        void add(int len, long value) {
            square += len*value*value + 2*value*sum;
            sum += len * value;
        }
    }
}