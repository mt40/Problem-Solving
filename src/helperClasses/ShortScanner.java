package helperClasses;

import java.util.Scanner;

public class ShortScanner {
    Scanner in;

    public ShortScanner(Scanner in) {
        this.in = in;
    }

    public int i() {
        return in.nextInt();
    }

    public long l() {
        return in.nextLong();
    }

    public double d() {
        return in.nextDouble();
    }

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
