package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_608A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), s = in.i();
        int []f = new int[s + 1];
        Arrays.fill(f, 0);
        for(int i = 0; i < n; ++i) {
            int x = in.i(), y = in.i();
            f[x] = Math.max(f[x], y);
        }
        int time = -1;
        for(int i = s; i >= 0; --i) {
            time++;
            time += Math.max(0, f[i] - time);
        }

        out.println(time);
    }
}
