package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class LongestValidSubstring {
    /**
     * Given a string of parentheses. Find the longest valid substring
     * The naive approach: find all the substring and validate them -> O(n^2)
     * DP approach: TODO
     * Stack approach: use a magic trick -> O(n) wait, wat?!
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        char []a = s.toCharArray();
        int n = a.length;

        int max_len = 0, L = 0, R = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1); // IMPORTANT!

        for(int i = 0; i < n; ++i) {
            if(a[i] == '(')
                stack.push(i);
            else {
                stack.pop();
                // if this is a valid string
                if(!stack.isEmpty()) {
                    int len = i - stack.peek();
                    if(len > max_len) {
                        max_len = len;
                        L = i - max_len + 1;
                        R = i;
                    }
                }
                // if not, then push this ')' as a base to calculate
                // future valid string
                else
                    stack.push(i);
            }
        }

        out.printf("%d\n%s\n", max_len, s.substring(L, R + 1));
    }
}
