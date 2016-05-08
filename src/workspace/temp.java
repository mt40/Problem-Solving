package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Comparator;
import java.util.PriorityQueue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class temp {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        C item = new C();
        item.f();
        ((D)item).f();
    }

    interface A {
        void f();
    }

    interface B {
        void f();
    }

    abstract class D {
        public void f() {
            System.out.println("D");
        }
    }

    class C extends D implements A, B {
    }
}