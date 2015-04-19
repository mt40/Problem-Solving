package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SPOJ_ONP {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char []exp = in.next().toCharArray();
        int n = exp.length;

        // contains numbers
        Deque<Character> num = new ArrayDeque<Character>();
        // contains +,-,*,/,(,)
        Deque<Character> op = new ArrayDeque<Character>();

        for(int i = 0; i < n; ++i) {
            if(isNumber(exp[i]))
               num.push(exp[i]);
            else if(exp[i] == ')') {
                // pop until see '('
                while(op.peek() != '(')
                    num.push(op.pop());
                op.pop(); // pop '('
            }
            else {
                if(exp[i] != '(') {
                    // pop any operator with higher precedence
                    while (op.size() > 0 && precedence(exp[i]) < precedence(op.peek()))
                        num.push(op.pop());
                }
                op.push(exp[i]);
            }
        }

        while(num.size() > 0)
            out.print(num.pollLast());
        out.println();
    }

    int precedence(char op) {
        switch (op) {
            case '+': return 0;
            case '-': return 0;
            case '*': return 1;
            case '/': return 1;
            case '^': return 2;
            default: return -1; // for '('
        }
    }

    boolean isNumber(char c) {
        return c >= 'a' && c <= 'z';
    }
}
