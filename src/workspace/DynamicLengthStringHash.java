package workspace;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.omg.CORBA.Environment;

import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class DynamicLengthStringHash {
    char []pool = {
            '_','_','_','_',
            '0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int len = in.nextInt(); //output hash string length
        int sample_size = 1000000;
        LinkedList<String> data = genRandom(sample_size, len);

        String userHomeFolder = System.getProperty("user.home"); // get desktop path
        File textFile = new File(userHomeFolder + "/Desktop/objectid/", "input.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(textFile));
            for (String s : data) {
                char[] a = s.toCharArray();
                int n = a.length;

                int[] xor = new int[len];
                for (int i = 0; i < n; ++i) {
                    xor[i % len] = (int) a[i] ^ xor[i % len];
                }

                String hash = toHash(xor);
                byte[] bytes = hash.getBytes();
                String hex = HexBin.encode(bytes);
                writer.write(hex);
                writer.newLine();
            }
        } catch (Exception e) {

        } finally {
            if(writer != null)
                try {
                    writer.close();
                }catch(Exception e){}
        }
    }

    LinkedList<String> genRandom(int limit, int hash_len) {
        LinkedList<String> rs = new LinkedList<String>();
        for (int i = 0; i < limit; ++i) {
            String rand = genString(randInt(4, 100));
            rand = padRight(rand, hash_len);
            rs.add(rand);
        }

        return rs;
    }

    Random randomizer = new Random();
    String genString(int len) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; ++i) {
            sb.append(pool[randInt(0, pool.length)]);
        }

        return sb.toString();
    }

    /**
     * Random an integer between min(inclusive) and max(exclusive)
     */
    int randInt(int min, int max) {
        return randomizer.nextInt(max - min) + min;
    }

    String toHash(int[] xor) {
        StringBuilder sb = new StringBuilder();
        for (int i : xor) {
            sb.append((char) i);
        }

        return sb.toString();
    }

    /**
     * Add more character so that the 'origin' will have length
     * equals to a multiple of 'factor'
     */
    String padRight(String origin, int factor) {
        int newLength = factor * (int) Math.ceil(origin.length() / factor);
        int diff = newLength - origin.length();

        StringBuilder sb = new StringBuilder();
        sb.append(origin);
        for (int i = 0; i < diff; ++i) {
            sb.append(origin.charAt(i % origin.length()));
        }

        return sb.toString();
    }
}
