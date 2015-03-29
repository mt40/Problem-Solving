package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class SPOJ_BMJ {
    int []X, Y;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int max = 200000; // lấy đại 1 số lớn hơn 100000
        X = new int[max];
        Y = new int[max];

        /**
         * Dựng các điểm trên hệ trục Oxy sẽ thấy dc pattern của nó
         */
        int len = 1;
        int cell = 2, x, y;
        while(cell < 100000) {
            for(x = len - 1, y = 1; x > 0; --x, ++y, cell++)
                update(cell, x, y);
            for(x = 0; x > -len; --x, cell++)       update(cell, x, len);
            for(y = len; y > 0; --y, cell++)        update(cell, x, y);
            for(x = -len; x < 0; ++x, --y, cell++)  update(cell, x, y);
            for(x = 0; x < len; ++x, cell++)        update(cell, x, y);
            for(y = -len; y < 0; ++y, cell++)       update(cell, x, y);

            update(cell, len, y);
            len++; cell++;
        }

        // input
        while(true) {
            try {
                int n = in.nextInt();
                out.format("%d %d\n", X[n], Y[n]);
            }
            catch (Exception e) {
                return;
            }
        }
    }

    void update(int cell, int x, int y) {
        X[cell] = x;
        Y[cell] = y;
    }
}
