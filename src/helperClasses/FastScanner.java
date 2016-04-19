package helperClasses;

/**
 * Created by mt on 1/8/2016.
 */
public class FastScanner {
    InputReader in;

    public FastScanner(InputReader in) {
        this.in = in;
    }

    public boolean b() { return in.nextBool(); }

    public int i() {
        return in.nextInt();
    }

    public long l() { return in.nextLong(); }

    public String s() {
        return in.next();
    }

    public String sl() {
        return in.nextLine();
    }

    public char[] c() {
        return c(false);
    }

    public char[] c(boolean from1) {
        char []tmp = in.next().toCharArray();
        if(from1) {
            char []a = new char[tmp.length + 1];
            System.arraycopy(tmp, 0, a, 1, tmp.length);
            return a;
        }
        return tmp;
    }

    public char[][] c(int n, int m) {
        return c(n, m, false);
    }

    public char[][] c(int n, int m, boolean from1) {
        int start = from1 ? 1 : 0;
        n += start;
        m += start;
        char [][]a = new char[n][m];
        for (int i = start; i < n; ++i) {
            char []t = c();
            System.arraycopy(t, 0, a[i], start, t.length);
        }
        return a;
    }

    public int[] arr(int n) { return arr(n, false); }

    public int[] arr(int n, boolean from1) {
        int []a;
        if(from1) {
            a = new int[n + 1];
            for (int i = 1; i <= n; ++i) a[i] = in.nextInt();
        }
        else {
            a = new int[n];
            for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        }
        return a;
    }

    public int[][] arr(int n, int m) {
        int [][]a = new int[n][m];
        for (int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                a[i][j] = in.nextInt();
        return a;
    }

    public long[] arrl(int n) { return arrl(n, false); }

    public long[] arrl(int n, boolean from1) {
        long []a;
        if(from1) {
            a = new long[n + 1];
            for (int i = 1; i <= n; ++i) a[i] = in.nextLong();
        }
        else {
            a = new long[n];
            for (int i = 0; i < n; ++i) a[i] = in.nextLong();
        }
        return a;
    }
}
