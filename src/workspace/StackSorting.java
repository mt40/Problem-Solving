package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class StackSorting {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<Integer>();
        for(int x : a) {
            stack.push(x);
        }

        sort(stack);
        for(int x : stack)
            out.print("" + x + " ");
        out.println();
    }

    void sort(Stack<Integer> stack) {
        for(int i = 0; i < stack.size(); ++i) {
            int top = stack.pop();
            boolean rs = insert(stack, top);
            if(rs == false) // largest element
                stack.push(top);
        }
    }

    boolean insert(Stack<Integer> stack, int x) {
        if(stack.size() == 0) return false;
        int top = stack.pop();
        boolean done = insert(stack, x);
        if(done == false && top >= x) {
            stack.push(x);
            done = true;
        }
        stack.push(top);
        return done;
    }
}
