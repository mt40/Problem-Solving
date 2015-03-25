package workspace;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

// UVa 847 - A Multiplication Game
public class AMultiplicativeGame {
    Map<Integer, Boolean> dp;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        dp = new HashMap<Integer, Boolean>();

        int rs = whoWin(n, 1, 0);
        if(rs == 0)
            out.println("Stan wins.");
        else
            out.println("Ollie wins.");
    }


    public int whoWin(int n, int start, int player) {
        for(int i = 2; i <= 9; ++i) {
            //System.out.format("%d: %d * %d = %d\n", player, start, i, start * i);
            if(start * i >= n)
                return player; // win!

            if(dp.containsKey(start * i)) {
                if(dp.get(start * i))
                    return player; // already calculated
                continue; // continue to find a way for player to win
            }

            boolean cal = whoWin(n, start * i, (player + 1) % 2) == player;
            dp.put(start * i, cal);
            System.out.format("dp(%d) = %b - player %d\n", start * i, cal, player);
            if(cal == true) return player;
        }

        return (player + 1) % 2; // no way for this other player to win
    }
}
