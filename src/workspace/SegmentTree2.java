package workspace;

import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;
import helperClasses.ShortScanner;
import helperClasses.Util;

public class SegmentTree2 {
    int inf = Integer.MAX_VALUE;

    /**
     * Previous implementation is in fact something called
     * Sparse Table (so it is not SegmentTree)
     * ref: http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range
     */
    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = in.i();
        int []a = in.arr(n);
        SegmentTree tree = new SegmentTree(a);

        while(m-- > 0) {
            String type = in.s();
            if(type.equals("sum")) {
                int l = in.i(), r = in.i();
                out.println(tree.getSum(n, l - 1, r - 1));
            }
            else if (type.equals("set")) {
                int index = in.i() - 1, newVal = in.i();
                tree.update(n, index, newVal - a[index]);
                a[index] = newVal;
            }
            else if(type.equals("range")) {
                int l = in.i() - 1, r = in.i() - 1, diff = in.i();
                tree.updateRange(n, l, r, diff);
                for(int i = l; i <= r; ++i) {
                    a[i] += diff;
                }
            }
        }
    }

    class SegmentTree {
        int []st; // store tree nodes
        int []lazy; // cache update

        public SegmentTree(int []a) {
            int n = a.length;
            int h = (int)(Math.ceil(Math.log(n) / Math.log(2))); // tree height
            int size = (int)(Math.pow(2, h + 1) - 1);
            st = new int[size];
            lazy = new int[size];

            construct(a, 0, n - 1, 0);
        }

        public int getSum(int n, int l, int r) {
            return getSum(0, n - 1, new Query(l, r), 0);
        }

        public void update(int n, int index, int diff) {
            update(0, n - 1, index, diff, 0);
        }

        public void updateRange(int n, int l, int r, int diff) {
            //updateRange(0, n - 1, new Query(l, r), diff, 0);
            updateRangeLazy(0, n - 1, new Query(l, r), diff, 0);
        }

        private int construct(int []a, int l, int r, int i) {
            if(l == r) {
                st[i] = a[l];
                return a[l];
            }

            int mid = getMid(l, r);
            st[i] = construct(a, l, mid, leftChild(i))
                    + construct(a, mid + 1, r, rightChild(i));
            return st[i];
        }

        private int getSum(int l, int r, Query q, int i) {
            // check for pending update
            if(lazy[i] > 0) doPendingUpdate(l, r, 0);

            // if this segment is inside query range
            if(q.l <= l && r <= q.r)
                return st[i];

            // out of range
            if(q.r < l || r < q.l)
                return 0;

            // partially within range
            int mid = getMid(l, r);
            return getSum(l, mid, q, leftChild(i))
                    + getSum(mid + 1, r, q, rightChild(i));
        }

        /**
         * Update value at array 'index'
         * @param index index in the original array
         * @param diff old and new value difference
         * @param i index of current tree node
         */
        private void update(int l, int r, int index, int diff, int i) {
            // out of range
            if(index < l || r < index) return;

            // inside range
            st[i] += diff;
            if(l != r) {
                int mid = getMid(l, r);
                update(l, mid, index, diff, leftChild(i));
                update(mid + 1, r, index, diff, rightChild(i));
            }
        }

        private void updateRangeLazy(int l, int r, Query q, int diff, int i) {
            // If there is pending update for this node
            if(lazy[i] > 0)
                doPendingUpdate(l, r, i);

            if(l > r || q.r < l || r < q.l) return;

            /* Completely inside update range */
            if(q.l <= l && r <= q.r) {
                /* we have to add for all the children cause
                they will not be update for now */
                st[i] += (r - l + 1) * diff;

                if(l != r) { // not leaf
                    lazy[leftChild(i)] += diff;
                    lazy[rightChild(i)] += diff;
                }
                return;
            }

            /* Partially inside the update range */
            int mid = getMid(l, r);
            updateRangeLazy(l, mid, q, diff, leftChild(i));
            updateRangeLazy(mid + 1, r, q, diff, rightChild(i));

            // update this node base on its children
            st[i] = st[leftChild(i)] + st[rightChild(i)];
        }

        void doPendingUpdate(int l, int r, int i) {
            st[i] += (l - r + 1) * lazy[i];

            if(l != r) { // not leaf
                /* propagate the update to children
                to remember that they need to be update later */
                lazy[leftChild(i)] += lazy[i];
                lazy[rightChild(i)] += lazy[i];
            }
            lazy[i] = 0; // pending update is processed
        }

        /**
         * Add diff to all elements in range of Query.
         * But this implementation is too slow since we have to
         * update all the node in the subtree inside the range.
         * See updateRangeLazy for faster speed.
         * @param q Specify the range
         * @param diff value to be added
         */
        private void updateRange(int l, int r, Query q, int diff, int i) {
            // out of range
            if(l > r || q.r < l || r < q.l) return;

            if(l == r) {
                st[i] += diff;
                return;
            }
            int mid = getMid(l, r);
            updateRange(l, mid, q, diff, leftChild(i));
            updateRange(mid + 1, r, q, diff, rightChild(i));
            // update this node base on its children
            st[i] = st[leftChild(i)] + st[rightChild(i)];
        }

        private int getMid(int l, int r) {
            return l + (r - l) / 2;
        }

        private int leftChild(int i) {
            return i * 2 + 1;
        }

        private int rightChild(int i) {
            return i * 2 + 2;
        }
    }

    class Query {
        int l, r;

        public Query(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
