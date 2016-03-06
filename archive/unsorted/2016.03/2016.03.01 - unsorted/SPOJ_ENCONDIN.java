package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ENCONDIN {
    int inf = Integer.MAX_VALUE;
    PrintWriter out;
    public void solve(int testNumber, InputReader input, PrintWriter oo) {
        FastScanner in = new FastScanner(input);
        out = oo;
        int t = 0;
        while (true) {
            String s;
            if((s = in.sl()) == null) return;
            char []a = s.toCharArray();
            if(t > 0)
                out.println();

            if(a.length > 0) {
                Deque<Character> listDif = new LinkedList<>();
                char prev = a[0];
                listDif.add(prev);
                for (int i = 1; i < a.length; ++i) {
                    char c = a[i];
                    if (c == prev) {
                        listDif.pollLast(); // remove the first of this sequence
                        printDif(listDif); // print the remaining chars
                        int len = 1;
                        while (i < a.length && a[i] == prev) {
                            len++;
                            i++;
                        }
                        i--;
                        if (len % 9 == 1) { // for example 10
                            listDif.add(prev);
                            len--;
                        }
                        printSim(prev, len);
                    }
                    else {
                        listDif.add(c);
                        prev = c;
                    }
                }
                if (!listDif.isEmpty())
                    printDif(listDif);
            }
            t++;
        }
    }

    void printSim(char c, int len) {
        while(len >= 9) {
            out.printf("9%c", c);
            len -= 9;
        }
        if(len > 0)
            out.printf("%d%c", len, c);
    }

    void printDif(Deque<Character> dif) {
        if(dif.isEmpty()) return;
        out.print(1);
        while(!dif.isEmpty())
            out.print(stringFor(dif.pollFirst()));
        out.print(1);
    }

    String stringFor(char c) {
        if(c == '1') return "11";
        return "" + c;
    }
}