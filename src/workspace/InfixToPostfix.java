package workspace;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class InfixToPostfix {
    /**
     * Implementation of Shunting Yard algorithm to convert
     * infix notation to postfix notation
     * https://en.wikipedia.org/wiki/Shunting-yard_algorithm
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        char []infix = s.toCharArray();
        int n = infix.length;
        Stack<Character> output = new Stack<Character>();
        Stack<Character> ops = new Stack<Character>();

        for(int i = 0; i < n; ++i) {
            char c = infix[i];
            if(isDigit(c)) {
                output.push(c);
            }
            else {
                int p = precedence(c);
                while(ops.size() > 0 && p <= precedence(ops.peek())) {
                    output.push(ops.pop());
                }
                ops.push(c);
            }
        }
        while(ops.size() > 0) {
            output.push(ops.pop());
        }

        for(char c : output)
            out.printf("%c", c);
        out.println();
    }

    int precedence(char c) {
        switch (c) {
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
        }
        return 0;
    }

    boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
