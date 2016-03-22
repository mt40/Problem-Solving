package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_BINGO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String keyword = "BULLSHIT", words;
        HashSet<String> set = new HashSet<>();
        int total = 0, games = 0;
        while (true) {
            try{ words = in.s();}
            catch(Exception e) {break;}
            //if(!Character.isAlphabetic(words.charAt(0))) continue; // ignore delimiters

            //words = words.toLowerCase();
            String []parts = words.split("[^A-Za-z]");

            for(String word : parts) {
                if(word.length() == 0) continue;
                if (word.equals(keyword)) {
                    total += set.size();
                    set.clear();
                    games++;
                } else set.add(word.toLowerCase());
            }
        }

        int g = gcd(total, games);
        out.printf("%d / %d\n", total/g, games/g);
    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}