package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class TowerOfHanoi {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(); // number of disks
        int pos = in.nextInt(); // current position
        int des = in.nextInt(); // destination

        //move(n, pos, des);
        moveIter(n, pos, des);
        System.out.println("finish!\n");
    }

    // recursive version
    public void move(int n, int pos, int des) {
        if(n == 1) {
            System.out.format("Move 1 disk from %d -> %d\n", pos, des);
            return;
        }
        move(n - 1, pos, 6 - pos - des); // move n - 1 disks to another column
        move(1, pos, des); // move the lowermost disk to destination
        move(n - 1, 6 - pos - des, des); // move n - 1 back to destination
    }

    // iterative version
    public void moveIter(int n, int pos, int des) {
        long moves = (1 << n) - 1; // 2^n

        int aux = 6 - pos - des; // auxiliary pole
        if((n & 1) == 0) { // swap dest and auxiliary pole
            aux = des;
            des = 6 - pos - aux;
        }

        for(int i = 1; i <= moves; ++i) {
            if(i % 3 == 1)
                moveBetween(pos, des);
            if(i % 3 == 2)
                moveBetween(pos, aux);
            if(i % 3 == 0)
                moveBetween(aux, des);
        }
    }

    void moveBetween(int pole1, int pole2) {
        System.out.format("Move 1 disk between %d & %d\n", pole1, pole2);
    }
}
