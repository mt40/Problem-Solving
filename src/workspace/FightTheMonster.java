package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class FightTheMonster {
    int h1, a1, d1, h2, a2, d2;
    int []p;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        h1 = in.nextInt(); a1 = in.nextInt(); d1 = in.nextInt();
        h2 = in.nextInt(); a2 = in.nextInt(); d2 = in.nextInt();
        p = new int[3];
        for(int i = 0; i < 3; ++i)
            p[i] = in.nextInt();

        out.println(binary());
    }

    public int binary() {
        int low = 0, hi = (100 -  h1)*p[0] + (100 - a1)*p[1] + (100 - d1)*p[2], min = hi;
        while(low <= hi) {
            int mid = (low + hi) / 2;
            boolean canWin = check(mid, 300 - h1 - a1 - d1, new int[]{h1, a1, d1});
            if(canWin) {
                if(mid < min)
                    min = mid;
                hi = mid - 1;
            }
            else
                low = mid + 1;
        }
        return min;
    }

    public boolean check(int money, int limit, int[]stat) {
        System.out.println(limit);
        if(limit < 0)
            return false;
        int hits1 = calHits(stat[0], a2 - stat[2]);
        int hits2 = calHits(h2, stat[1] - d2);
        if(hits1 > hits2) {
            return true; // if Yang can endure more hits
        }

        for(int i = 0; i < 3; ++i) {
            if(money - p[i] >= 0) {
                stat[i]++;
                boolean win = check(money - p[i], limit - 1, stat);
                if(win)
                    return win;
                stat[i]--;
            }
        }
        return false;
    }

    public int calHits(int hp, int dmg){
        if(dmg <= 0)
            return Integer.MAX_VALUE;
        return (int)Math.ceil(hp * 1.0 / dmg);
    }
}
