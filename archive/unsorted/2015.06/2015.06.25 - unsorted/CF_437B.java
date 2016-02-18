package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_437B {
    int total;
    int []choose, cnt;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int lim = in.nextInt();

        total = 0;
        choose = new int[100001];
        cnt = new int[100001];
        for(int i = 1; i <= lim; ++i) {
            int pos = lowbit(i);
            cnt[pos]++;
        }

        int cur = 1 << 16;
        while(cur > 0) {
            if((cur & n) > 0) { // position of '1'
                if(cnt[cur] > 0) {
                    use(cur);
                }
                else {
                    for(int i = 1; i < cur; i <<= 1) {
                        use(i);
                        if(cnt[i] < 0) {
                            out.println(-1);
                            return;
                        }
                    }
                    use(1);
                    if(cnt[1] < 0) {
                        out.println(-1);
                        return;
                    }
                }
            }
            cur >>= 1;
        }

        out.println(total);
        for(int i = 1; i <= lim; ++i) {
            int bit = lowbit(i);
            if(choose[bit] > 0) {
                out.print(i + " ");
                choose[bit]--;
            }
        }
    }

    int lowbit(int i) {
        return (i ^ (i - 1)) & i;
    }

    void use(int i) {
        cnt[i]--;
        choose[i]++;
        total++;
    }
}
