package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class ChangeBase {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();

        out.println(toBin(n));
        out.println(toBase(n, 16));
    }

    String toBin(int x) {
        String rs = "";
        for(int i = 0; i < 32; ++i)
            rs = (x & (1 << i)) > 0 ? '1' + rs : '0' + rs;
        return rs;
    }

    // Base < 9
    String toBase(int x, int base) {
        String rs = "";
        while(x > 0) {
            rs = getSymbol((x % base)) + rs;
            x /= base;
        }
        return rs;
    }

    char getSymbol(int x) {
        switch (x) {
            case 10: return 'a';
            case 11: return 'b';
            case 12: return 'c';
            case 13: return 'd';
            case 14: return 'e';
            case 15: return 'f';
            default: return (char)(x + '0'); // less than 10
        }
    }
}
