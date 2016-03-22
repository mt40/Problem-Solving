package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CMEXPR {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = in.c();
        int n = a.length;

        Stack<Integer> stack = new Stack<>();
        Queue<Pair> parens = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            if(a[i] == '(') stack.add(i);
            if(a[i] == ')') {
                int start = stack.pop();
                parens.add(new Pair(start, i));
            }
        }
        precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('(', 0);
        precedence.put(')', 0);

        String postFix = cal(a);
        String ans = String.valueOf(a);
        int remain = n;
        boolean []mark = new boolean[n];
        for(Pair par : parens) {
            mark[par.a] = mark[par.b] = true; // marked as removed
            remain -= 2;

            char []removed = new char[remain];
            for(int i = 0, idx = 0; i < n; ++i) {
                if(mark[i]) continue;
                removed[idx++] = a[i];
            }

            String tmp = cal(removed);
            if(!tmp.equals(postFix)) { // cannot remove this pair, undo!
                remain += 2;
                mark[par.a] = mark[par.b] = false;
            }
            else
                ans = String.valueOf(removed);
        }

        out.println(ans);
    }

    HashMap<Character, Integer> precedence;

    int precedenceCompare(char a, char b) {
        return Integer.compare(precedence.get(a), precedence.get(b));
    }

    String cal(char []infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : infix) {
            if(Character.isAlphabetic(c))
                sb.append(c);
            else if(c == '(')
                stack.add(c);
            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());
                stack.pop(); // pop '('
            }
            else {
                while(!stack.isEmpty() && precedenceCompare(c, stack.peek()) <= 0) {
                    sb.append(stack.pop());
                }
                stack.add(c);
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}