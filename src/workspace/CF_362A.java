package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_362A {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int t = in.i();
        while(t-- > 0) {
            char [][]b = new char[9][9];
            for(int i = 1; i <= 8; ++i) {
                char []tmp = in.c();
                for(int j = 1; j <= 8; ++j) {
                    b[i][j] = tmp[j-1];
                }
            }

            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            L1:
            for(int i = 1; i <= 8; ++i) {
                for(int j = 1; j <= 8; ++j) {
                    if(b[i][j] == 'K') {
                        x1 = i; y1 = j; break L1;
                    }
                }
            }
            for(int i = 1; i <= 8; ++i) {
                for(int j = 1; j <= 8; ++j) {
                    if(b[i][j] == 'K' && (i != x1 || j != y1)) {
                        x2 = i; y2 = j;
                    }
                }
            }

            int [][]move1 = new int[9][9], move2 = new int[9][9];
            go(move1, x1, y1, 0);
            go(move2, x2, y2, 0);
            boolean ok = false;
            L2:
            for(int i = 1; i <= 8; ++i) {
                for(int j = 1; j <= 8; ++j) {
                    if(Math.abs(move1[i][j] - move2[i][j]) % 2 == 0 && b[i][j] != '#'
                            && move1[i][j] * move2[i][j] > 0) {
                        out.println("YES");
                        ok = true; break L2;
                    }
                }
            }
            if(!ok) out.println("NO");
        }
    }

    void go(int [][]move, int x, int y, int cnt) {
        if(x <= 0 || x > 8 || y <= 0 || y > 8) return;
        if(move[x][y] != 0 && move[x][y] <= cnt + 1) return; // visited
        move[x][y] = cnt + 1;
        go(move, x - 2, y - 2, move[x][y]);
        go(move, x - 2, y + 2, move[x][y]);
        go(move, x + 2, y - 2, move[x][y]);
        go(move, x + 2, y + 2, move[x][y]);
    }
}
