package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_205B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []a = in.readArr(n);

        long added = 0;
        for(int i = 1; i < n; ++i) {
            added += Math.max(0, a[i - 1] - a[i]);
        }

        out.println(added);
    }
}
