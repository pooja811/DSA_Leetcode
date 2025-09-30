import java.util.*;

class RecentCounter {
    Queue<Integer> q = new LinkedList<>();
    public RecentCounter() {}
    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000) q.poll(); // clear old
        return q.size();
    }
}