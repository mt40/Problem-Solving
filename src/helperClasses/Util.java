package helperClasses;

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
}
