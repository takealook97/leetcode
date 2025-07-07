import java.util.*;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int idx = 0, day = 1, answer = 0, len = events.length, max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] event : events) {
            max = Math.max(max, event[1]);
        }

        while (day <= max) {
            while (idx < len && events[idx][0] == day) {
                pq.add(events[idx++][1]);
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                answer++;
            }

            day++;
        }

        return answer;
    }
}
