class Solution {
    public int minOperations(int[] nums, int k) {
        int len = nums.length, answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }

        while (pq.size() >= 2) {
            int x = pq.poll();
            int y = pq.poll();
            int min = Math.min(x, y);
            int max = Math.max(x, y);
            System.out.println(min + " " + max);
            if (min >= k) {
                break;
            }

            pq.add(min * 2 + max);
            answer++;
        }

        return answer;
    }
}
