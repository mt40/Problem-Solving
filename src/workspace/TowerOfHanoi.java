package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class TowerOfHanoi {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(); // number of disks
        int pos = in.nextInt(); // current position
        int des = in.nextInt(); // destination

        move(n, pos, des);
        System.out.println("finish!\n");
    }

    public void move(int n, int pos, int des) {
        if(n == 1) {
            System.out.format("Move 1 disk from %d -> %d\n", pos, des);
            return;
        }
        move(n - 1, pos, 6 - pos - des); // move n - 1 disks to another column
        move(1, pos, des); // move the lowermost disk to destination
        move(n - 1, 6 - pos - des, des); // move n - 1 back to destination
    }
}
