package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class UnionOfInterval {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Node []a = new Node[2 * n];
        for(int i = 0, j = 0; i < n; ++i, j += 2) {
            a[j] = new Node(in.nextInt(), false);
            a[j + 1] = new Node(in.nextInt(), true);
        }

        Arrays.sort(a);

        int id = 0, l = 0, r = 0, count = 0;
        for(Node x : a) {
            if(!x.isEndPoint) {
                if(count == 0)
                    l = x.value;
                count++;
            }
            else {
                count--;
                if(count == 0) {
                    r = x.value;
                    out.printf("%d: %d %d\n", id, l , r);
                    id++;
                }
            }
        }
    }

    class Node implements Comparable<Node> {
        boolean isEndPoint;
        int value;

        public Node(int value, boolean isEndPoint) {
            this.isEndPoint = isEndPoint;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(value == o.value) {
                return Boolean.compare(isEndPoint, o.isEndPoint);
            }
            return Integer.compare(value, o.value);
        }

        @Override
        public String toString() {
            return "" + value + " " + isEndPoint;
        }
    }
}
