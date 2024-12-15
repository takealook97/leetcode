class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int len = classes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                ((double) b[0] + 1) / (b[1] + 1) - (double) b[0] / b[1],
                ((double) a[0] + 1) / (a[1] + 1) - (double) a[0] / a[1]
            )
        );
        
        for (int[] c : classes) {
            pq.add(c);
        }

        while (extraStudents-- > 0) {
            int[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.add(c);
        }

        double answer = 0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            answer += (double) c[0] / c[1];
        }

        return answer / len;
    }
}
