class Solution {
    public int minimumCost(int[] nums) {
        int answer = nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            pq.add(nums[i]);
        }

        answer += pq.poll();
        answer += pq.poll();
        return answer;
    }
}