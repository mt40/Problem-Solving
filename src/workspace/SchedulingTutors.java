package workspace;

import java.util.*;
import java.io.PrintWriter;

public class SchedulingTutors {
    /**
     * A tutor can only work for 2 hours. A lesson lasts exactly 30 min.
     * Find the number of min tutors needed
     * Here we represent 1h = 100, 1h30 = 150
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        List<Lesson> list = new ArrayList<Lesson>();
        for(int i = 0; i < n; ++i)
            list.add(new Lesson(in.nextInt()));
        Collections.sort(list, lesson_cp);
        PriorityQueue<Tutor> heap = new PriorityQueue<Tutor>(10, tutor_cp);
        int ans = 0;
        for(Lesson ls : list) {
            while(true) {
                if(heap.size() == 0) {
                    heap.add(new Tutor(ls.start, 200));
                    ans++;
                }
                Tutor t = heap.peek();
                if(t.remain < 50)
                    heap.remove(t);
                else if(ls.start < t.start) {
                    heap.add(new Tutor(ls.start, 200));
                    ans++;
                }
                else {
                    // this tutor can teach
                    t = heap.poll();
                    t.start = ls.end;
                    t.remain -= 50;
                    heap.add(t);
                    break;
                }
            }
        }
        out.println(ans);
    }

    class Tutor{
        int start, remain;

        public Tutor(int start, int remain) {
            this.start = start;
            this.remain = remain;
        }
    }

    class Lesson {
        int start, end;

        public Lesson(int start) {
            this.start = start;
            this.end = start + 50;
        }
    }

    Comparator<Lesson> lesson_cp = new Comparator<Lesson>() {
        @Override
        public int compare(Lesson o1, Lesson o2) {
            return Integer.compare(o1.start, o2.start);
        }
    };

    Comparator<Tutor> tutor_cp = new Comparator<Tutor>() {
        @Override
        public int compare(Tutor o1, Tutor o2) {
            return Integer.compare(o1.start, o2.start);
        }
    };


}
