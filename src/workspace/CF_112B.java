package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_112B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), x = in.i(), y = in.i();
        boolean [][]a = new boolean[n + 1][n + 1];
        int cnt = 0;
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(isNear(i, j, x, y)) {
                    cnt++;
                }
            }
        }

        boolean ok = x - n/2 <= 1 && x - n/2 >= 0 && y - n/2 <= 1 && y - n/2 >= 0;
        out.println((cnt + 1 <= n*n/2 && !ok) ? "YES" : "NO");
    }

    boolean isNear(int i, int j, int x, int y) {
        return (i == x && j + 1 == y) || (i == x && j - 1 == y)
                || (j == y && i + 1 == x) || (j == y && i - 1 == x)
                || (i + 1 == x && j + 1 == y) || (i - 1 == x && j - 1 == y)
                || (i - 1 == x && j + 1 == y) || (i + 1 == x && j - 1 == y);
    }
}
