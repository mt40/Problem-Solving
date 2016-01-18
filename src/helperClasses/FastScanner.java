package helperClasses;

/**
 * Created by mt on 1/8/2016.
 */
public class FastScanner {
    InputReader in;

    public FastScanner(InputReader in) {
        this.in = in;
    }

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
        return in.next().toCharArray();
    }

    public int[] arr(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        return a;
    }
}
