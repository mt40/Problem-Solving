package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;

public class SPOJ_HASHIT {
    int n = 101, LIMIT = 19;
    String[] a;
    int[] status; // 0:empty 1:full -1:deleted

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int m = in.nextInt();
        a = new String[n];
        status = new int[n];

        for(int i = 0; i < m; ++i) {
            String s = in.next();
            if(s.charAt(0) == 'A') {
                String []parts = s.split(":");
                if(!exist(parts[1]))
                    insert(parts[1]);
            }
            else {
                String []parts = s.split(":");
                if(exist(parts[1]))
                    delete(parts[1]);
            }
        }

        // output
        int cnt = 0;
        for(int i = 0; i < n; ++i)
            if(status[i] == 1)
                cnt++;
        out.println(cnt);
        for(int i = 0; i < n; ++i)
            if(status[i] == 1) {
                out.format("%d:%s\n", i, a[i]);
            }
    }

    Boolean exist(String x) {
        for(int i = 0; i < n; ++i)
            if(status[i] == 1 && a[i].equals(x))
                return true;
        return false;
    }

    Boolean insert(String x) {
        int pos = Hash(x);
        if (status[pos] == 1) { // not empty
            for (int i = 1; i <= LIMIT; ++i) {
                pos = nextPos(x, i);
                if (status[pos] <= 0) { // ok this position can be inserted
                    a[pos] = x;
                    status[pos] = 1;
                    return true;
                }
            }
            return false; // cannot insert
        }
        a[pos] = x;
        status[pos] = 1;
        return true;
    }

    void delete(String x) {
        int pos = Hash(x);
        if(a[pos] != null && a[pos].equals(x)) {
            status[pos] = -1; // mark as deleted
        }
        else {
            for(int i = 1; i <= LIMIT; ++i) {
                pos = nextPos(x, i);
                if(a[pos] != null && a[pos].equals(x)) {
                    status[pos] = -1;
                    break;
                }
            }
        }
    }

    int nextPos(String key, int j) {
        return (Hash(key) + j * j + 23 * j) % n;
    }

    int Hash(String key) {
        return h(key) % n;
    }

    int h(String key) {
        int ans = 0;
        int len = key.length();
        for (int i = 0; i < len; ++i) {
            ans += ((int)key.charAt(i)) * (i + 1);
        }
        return ans * 19;
    }
}
