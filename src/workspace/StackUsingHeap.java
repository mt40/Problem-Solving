package workspace;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class StackUsingHeap {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        // fake stack
        PriorityQueue<Node> stack = new PriorityQueue<Node>(Collections.reverseOrder());
        for(int i = 0; i < n; ++i) {
            stack.add(new Node(in.nextInt(), stack.size()));
        }

        out.println(Arrays.toString(stack.toArray()));
        out.println("Pop begins!");
        while(stack.size() > 0) {
            out.println(stack.poll());
        }
    }

    class Node implements Comparable<Node> {
        int value, index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "" + value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(index, o.index);
        }
    }
}
