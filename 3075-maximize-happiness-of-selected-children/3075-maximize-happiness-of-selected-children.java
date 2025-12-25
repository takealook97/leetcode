class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int h : happiness) {
            pq.add(h);
        }

        int d = 0, count = 0;
        long answer = 0;
        while (!pq.isEmpty()) {
            long h = pq.poll() - d;
            if (h <= 0 || count >= k) {
                break;
            }

            d++;
            count++;
            answer += h;
        }

        return answer;
    }
}
