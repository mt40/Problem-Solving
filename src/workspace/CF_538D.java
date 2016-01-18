package workspace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class CF_538D {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}char[] c(){return in.next().toCharArray();}int[] arr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}
    double max(double...v) {double m=Double.NEGATIVE_INFINITY; for (double d:v) if(d>m)m=d; return m;}
    long max(long...v) {long m=Long.MIN_VALUE; for(long i:v)if(i>m)m=i; return m;}
    double min(double...v) {double m=Double.POSITIVE_INFINITY; for (double d:v) if(d<m)m=d; return m;}
    long min(long...v) {long m=Long.MAX_VALUE; for(long i:v)if(i<m)m=i; return m;}
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        char [][]a = new char[n][n];
        for(int i = 0; i < n; ++i) {
            char []t = in.c();
            System.arraycopy(t, 0, a[i], 0, n);
        }

        Set<Pair> moves = new HashSet<>();
        for(int i = -n+1; i < n; ++i) {
            for(int j = -n+1; j < n; ++j) {
                if(i == 0 && j == 0) continue;
                moves.add(new Pair(i, j));
            }
        }

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(a[i][j] != 'o') continue;
                for(int x = 0; x < n; ++x) {
                    for(int y = 0; y < n; ++y) {
                        if(x == i & y == j) continue;
                        if(a[x][y] == '.') moves.remove(new Pair(x - i, y - j));
                    }
                }
            }
        }

        Set<Pair> used = new HashSet<>();
        char [][]b = new char[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                b[i][j] = (a[i][j] == 'o') ? 'o' : '.';
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(b[i][j] != 'o') continue;
                for(Pair p : moves) {
                    if(valid(n, i, j, p) && b[i + p.dx][j + p.dy] != 'o') {
                        if(b[i + p.dx][j + p.dy] == '.') used.add(p);
                        b[i + p.dx][j + p.dy] = 'x';
                    }
                }
            }
        }

        boolean ok = true;
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                if(a[i][j] != b[i][j]) ok = false;
        if(ok) {
            out.println("YES");
            char [][]c = new char[2*n-1][2*n-1];
            for(int i = 0; i < c.length; ++i) Arrays.fill(c[i], '.');
            c[n-1][n-1] = 'o';

            for(Pair p : used)
                c[n-1+p.dx][n-1+p.dy] = 'x';

            for(int i = 0; i < c.length; ++i)
                out.println(String.valueOf(c[i]));
        }
        else
            out.println("NO");
    }

    boolean valid(int n, int i, int j, Pair p) {
        return i + p.dx >= 0 && i + p.dx < n && j + p.dy >= 0 && j + p.dy < n;
    }

    class Pair {
        int dx, dy;

        public Pair(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (dx != pair.dx) return false;
            return dy == pair.dy;

        }

        @Override
        public int hashCode() {
            int result = dx;
            result = 31 * result + dy;
            return result;
        }
    }
}
