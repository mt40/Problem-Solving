package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_151B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String []names = new String[n];
        int [][]count = new int[n][3];

        int max_taxi = 0, max_pizza = 0, max_girl = 0;
        for(int i = 0; i < n; ++i) {
            int m = in.nextInt();
            names[i] = in.next();
            for(int j = 0; j < m; ++j) {
                String num = in.next();
                int type = getType(num);
                count[i][type]++;
            }

            max_taxi = Math.max(count[i][0], max_taxi);
            max_pizza = Math.max(count[i][1], max_pizza);
            max_girl = Math.max(count[i][2], max_girl);
        }

        out.print("If you want to call a taxi, you should call: ");
        boolean first = true;
        for(int i = 0; i < n; ++i) {
            if(count[i][0] == max_taxi) {
                out.print(first ? names[i] : ", " + names[i]);
                first = false;
            }
        }
        out.println('.');

        out.print("If you want to order a pizza, you should call: ");
        first = true;
        for(int i = 0; i < n; ++i) {
            if(count[i][1] == max_pizza) {
                out.print(first ? names[i] : ", " + names[i]);
                first = false;
            }
        }
        out.println('.');

        out.print("If you want to go to a cafe with a wonderful girl, you should call: ");
        first = true;
        for(int i = 0; i < n; ++i) {
            if(count[i][2] == max_girl) {
                out.print(first ? names[i] : ", " + names[i]);
                first = false;
            }
        }
        out.println('.');
    }

    int getType(String tel) {
        tel = tel.replace("-", "");
        char []a = tel.toCharArray();
        int type = 0;
        for(int i = 0; i < a.length; ++i) {
            if(a[i] != a[0]) {
                type = 1;
            }
        }

        if(type == 0)
            return type;

        for(int i = 1; i < a.length; ++i) {
            if(a[i] >= a[i - 1])
                type = 2;
        }

        return type;
    }
}
