package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ANARC05I {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a;
        while((a = in.c())[0] != 'Q') {
            Point p = new Point(0, 0);
            HashSet<Point> set = new HashSet<>();
            set.add(new Point(0, 0));
            int ans = 0;
            for(char ai : a) {
                if(ai == 'Q') break;
                p.go(ai);
                if(set.contains(p))
                    ans++;
                else
                    set.add(new Point(p.x, p.y));
            }

            out.println(ans);
        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void go(char command) {
            if(command == 'U')
                y++;
            else if(command == 'D')
                y--;
            else if(command == 'L')
                x--;
            else
                x++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}