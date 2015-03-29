package workspace;

import helperClasses.InputReader;
import jdk.internal.util.xml.impl.Pair;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class SPOJ_MBEEWALK {
    int []X, Y, D; // tọa độ x, y và khoảng cách đến tâm
    Map<String, Integer> data;
    int len;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        /**
         * Đầu tiên là dựng hệ tọa độ cho tổ ong
         */
        int max = 200000; // lấy đại 1 số lớn hơn 100000
        X = new int[max];
        Y = new int[max];
        D = new int[max];
        data = new HashMap<String, Integer>();
        /**
         * Dựng các điểm trên hệ trục Oxy sẽ thấy dc pattern của nó
         */
        len = 1;
        int cell = 2, x, y;
        while(cell < 100000 && len <= 7) {
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
        int n = in.nextInt();
        // TODO

        out.println(data.containsKey("1,0"));
    }

    void update(int cell, int x, int y) {
        data.put("" + x + "," + y, len);
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            return x == ((Point)o).x && y == ((Point)o).y;
        }
    }
}
