package helperClasses;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mt on 1/8/2016.
 */
public class Util {
    public static double max(double... v) {
        double m = Double.NEGATIVE_INFINITY;
        for (double d : v) if (d > m) m = d;
        return m;
    }

    public static long max(long... v) {
        long m = Long.MIN_VALUE;
        for (long i : v) if (i > m) m = i;
        return m;
    }

    public static int max(int... v) {
        int m = Integer.MIN_VALUE;
        for (int i : v) if (i > m) m = i;
        return m;
    }

    public static int maxIndex(int...v) {
        if(v.length == 0) return -1;
        int max = v[0], index = 0;
        for(int i = 1; i < v.length; ++i) {
            if(v[i] > max) {
                max = v[i];
                index = i;
            }
        }
        return index;
    }

    public static double min(double... v) {
        double m = Double.POSITIVE_INFINITY;
        for (double d : v) if (d < m) m = d;
        return m;
    }

    public static long min(long... v) {
        long m = Long.MAX_VALUE;
        for (long i : v) if (i < m) m = i;
        return m;
    }

    public static int min(int... v) {
        int m = Integer.MAX_VALUE;
        for (int i : v) if (i < m) m = i;
        return m;
    }

    public static char[] join(char[]...ar) {
        int n = 0;
        for(char []c : ar) n += c.length;
        char []rs = new char[n];
        int i = 0;
        for(char []ari : ar)
            for(char c : ari)
                rs[i++] = c;
        return rs;
    }

    /**
     * Get moves of the chess King
     */
    public static int[][] getKingMoves() {
        // left, up, right, down
        return new int[][] {{0,-1}, {-1,0}, {0,1}, {1,0}};
    }

    public static int[] unique(int []arr) {
        Set<Integer> set = new HashSet<>(arr.length);
        for(int ai : arr)
            set.add(ai);
        int []rs = new int[set.size()];
        int idx = 0;
        for(int si : set)
            rs[idx++] = si;
        return rs;
    }
}
