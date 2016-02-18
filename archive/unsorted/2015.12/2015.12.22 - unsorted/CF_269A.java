package workspace;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_269A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        Pair []pairs = new Pair[n];
        for(int i = 0; i < n; ++i)
            pairs[i] = new Pair(in.i(), in.i());

        int ans = 1;
        for(int i = 0; i < n; ++i) {
            Pair p = pairs[i];
            ans = Math.max(p.a + Math.max(1, (int)Math.ceil(log4(p.b))), ans);
        }

        out.println(ans);
    }

    double log4(int a) {
        return Math.log(a) / Math.log(4);
    }

    class Pair{
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
