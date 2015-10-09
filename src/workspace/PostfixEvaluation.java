package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class PostfixEvaluation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        char []postfix = s.toCharArray();
        int n = postfix.length;

        Stack<Integer> output = new Stack<Integer>();
        for(int i = 0; i < n; ++i) {
            char c = postfix[i];
            if(isDigit(c)) {
                output.push(c - '0');
            }
            else {
                int a = output.pop(), b = output.pop();
                output.push(calculate(b, a, c));
            }
        }
        out.println(output.peek());
    }

    int calculate(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
