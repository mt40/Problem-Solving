package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_56A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String []drinks = {"ABSINTH", "BEER", "BRANDY", "CHAMPAGNE", "GIN", "RUM", "SAKE", "TEQUILA", "VODKA", "WHISKEY", "WINE"};
        int n = in.nextInt();
        int count = 0;
        for(int i = 0; i < n; ++i) {
            String s = in.next();
            if(find(drinks, s) >= 0) {
                count++;
            }
            else if(Character.isDigit(s.charAt(0)) && Integer.valueOf(s) < 18) {
                count ++;
            }
        }
        out.println(count);
    }

    int find(String []arr, String s) {
        for(int i = 0; i < arr.length; ++i) {
            String a = arr[i];
            if(a.compareTo(s) == 0)
                return i;
        }
        return -1;
    }
}
