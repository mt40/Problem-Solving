package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RLM {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String s;
        while(true) {
            try { s = in.sl(); } catch (Exception e) {return;}
            if(s == null || s.length() == 0)
                return;

            String []parts = s.split(" ");
            Operand left = Operand.valueOf(parts[0]);
            char op = parts[1].charAt(0);
            Operand right = Operand.valueOf(parts[2]);

            Operand ans = left.cal(op, right);
            out.printf("%s = %s\n", s, ans);
        }
    }

    static class Operand {
        Digit []num;
        int len;

        private Operand(int len) {
            this.len = len;
            num = new Digit[len];
        }

        Operand cal(char op, Operand other) {
            if(op == '+')
                return add(other);
            if(op == '-')
                return subtract(other);
            if(op == '*')
                return mul(other);
            else
                return div(other);
        }

        Operand add(Operand other) {
            long a = this.longValue(), b = other.longValue();
            long rs = a + b;
            return valueOf(rs);
        }

        Operand subtract(Operand other) {
            long a = this.longValue(), b = other.longValue();
            long rs = a - b;
            return valueOf(rs);
        }

        Operand mul(Operand other) {
            long a = this.longValue(), b = other.longValue();
            long rs = a * b;
            return valueOf(rs);
        }

        Operand div(Operand other) {
            long a = this.longValue(), b = other.longValue();
            long rs = a / b;
            return valueOf(rs);
        }

        static Operand valueOf(String s) {
            char []a = s.toCharArray();
            Operand rs = new Operand(s.length() / 2);
            for(int i = 0, j = 0; i < s.length(); i += 2) {
                int cnt = a[i] - '0', val = a[i + 1] - '0';
                while (cnt > 0) {
                    rs.num[j++] = new Digit(Math.min(9, cnt), val);
                    cnt -= 9;
                }
            }
            return rs;
        }

        static Operand valueOf(long l) {
            char []a = Long.toString(l).toCharArray();
            List<Digit> list = new ArrayList<>();
            for(int i = 0; i < a.length; ++i) {
                int cnt = 1;
                while(i + 1 < a.length && a[i + 1] == a[i]) {
                    cnt++;
                    i++;
                }
                while (cnt > 0) {
                    list.add(new Digit(Math.min(9, cnt), a[i] - '0'));
                    cnt -= 9;
                }
            }
            Operand op = new Operand(list.size());
            int idx = 0;
            for(Digit d : list)
                op.num[idx++] = d;
            return op;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(Digit d : num)
                sb.append(d);
            return sb.toString();
        }

        long longValue() {
            StringBuilder full = new StringBuilder();
            for(Digit d : num) {
                full.append(d.toFullString());
            }
            return Long.valueOf(full.toString());
        }
    }

    static class Digit {
        int cnt, value;

        public Digit(int cnt, int value) {
            this.cnt = cnt;
            this.value = value;
        }

        @Override
        public String toString() {
            return cnt + "" + value;
        }

        String toFullString() {
            String s = "";
            for(int i = 0; i < cnt; ++i)
                s += value;
            return s;
        }
    }
}