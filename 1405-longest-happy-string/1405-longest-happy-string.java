import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        char A = 'a', B = 'b', C = 'c';

        if (a > 0) pq.add(new int[]{A, a});
        if (b > 0) pq.add(new int[]{B, b});
        if (c > 0) pq.add(new int[]{C, c});

        StringBuilder sb = new StringBuilder();

        int[] first, second;
        int len;
        while (!pq.isEmpty()) {
            first = pq.poll();

            len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == first[0] && sb.charAt(len - 2) == first[0]) {
                if (pq.isEmpty()) break;

                second = pq.poll();
                sb.append((char) second[0]);
                second[1]--;

                if (second[1] > 0) {
                    pq.add(second);
                } 

                pq.add(first);
            } else {
                sb.append((char) first[0]);
                first[1]--;

                if (first[1] > 0) {
                    pq.add(first);
                }
            }
        }

        return sb.toString();
    }
}
