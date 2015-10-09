package workspace;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class PostfixToInfix {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        char []postfix = s.toCharArray();
        int n = postfix.length;

        Stack<String> output = new Stack<String>();
        for(int i = 0; i < n; ++i) {
            char c = postfix[i];
            if(isDigit(c)) {
                output.push("" + c);
            }
            else {
                String a = output.pop(), b = output.pop();
                output.push(b + c + a);
            }
        }

        for(String str : output) {
            out.print(str);
        }
        out.println();
    }

    boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
