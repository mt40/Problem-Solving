package workspace;

import java.util.*;
import java.io.PrintWriter;

public class ViewFromAbove {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Segment[] a = new Segment[n];
        for (int i = 0; i < n; ++i) {
            int l = in.nextInt(), r = in.nextInt(), color = in.nextInt(), height = in.nextInt();
            a[i] = new Segment(l, r, color, height);
        }

        List<IntPair> end_points = new ArrayList<IntPair>();
        for(int i = 0; i < n; ++i) {
            end_points.add(new IntPair(a[i].start, i));
            end_points.add(new IntPair(a[i].end, i, true));
        }

        // sort by the start and end position of segments
        Collections.sort(end_points, new Comparator<IntPair>() {
            @Override
            public int compare(IntPair o1, IntPair o2) {
                return Integer.compare(o1.A, o2.A);
            }
        });

        int cur_x = end_points.get(0).A;
        // keep segments in a heap compared by height --> the highest height is at the top
        // heap in java has O(logn) removal time, pretty sweet!
        PriorityQueue<Segment> heap = new PriorityQueue<Segment>(n, new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return Integer.compare(o2.height, o1.height);
            }
        });

        for(IntPair ip : end_points) {
            int x_pos = ip.A;

            if(cur_x < x_pos) {
                int top = heap.peek().color;
                out.print(top + " ");
                cur_x = x_pos;
            }

            if(ip.isEnd)
                heap.remove(a[ip.B]);
            else
                heap.add(a[ip.B]);
        }
        out.println();
    }

    class Segment {
        int start, end, color, height;

        public Segment(int start, int end, int color, int height) {
            this.start = start;
            this.end = end;
            this.color = color;
            this.height = height;
        }
    }

    class IntPair {
        int A, B;
        boolean isEnd;

        public IntPair(int a, int b) {
            this.A = a;
            this.B = b;
        }

        public IntPair(int a, int b, boolean isEnd) {
            A = a;
            B = b;
            this.isEnd = isEnd;
        }
    }
}
