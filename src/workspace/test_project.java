package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class test_project {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Lumia p = new BadPhone();
        out.println(p.value);
        out.println(p.doSth());
    }

    interface IPhone {
        int value = 10;
        int doSth();
    }

    interface Lumia {
        int value = 12;
        int doSth();
    }

    class BadPhone implements IPhone, Lumia {
        @Override
        public int doSth() {
            return 11;
        }
    }
}
