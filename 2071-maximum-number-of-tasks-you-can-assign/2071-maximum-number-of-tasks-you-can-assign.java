import java.util.*;

class Solution {
    static int n, m;
    static Deque<Integer> deque;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        n = tasks.length;
        m = workers.length;
        deque = new ArrayDeque<>();

        int lo = 0, hi = Math.min(n, m), mid, answer = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isPossible(tasks, workers, pills, strength, mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }

    static boolean isPossible(int[] tasks, int[] workers, int pills, int strength, int count) {
        deque.clear();
        int p = pills;
        int idx = m - 1;

        for (int i = count - 1; i >= 0; i--) {
            int task = tasks[i];

            while (idx >= m - count && workers[idx] + strength >= task) {
                deque.addFirst(workers[idx--]);
            }

            if (deque.isEmpty()) {
                return false;
            } else if (deque.peekLast() >= task) {
                deque.pollLast();
            } else {
                if (p == 0) return false;
                p--;
                deque.pollFirst();
            }
        }

        return true;
    }
}
