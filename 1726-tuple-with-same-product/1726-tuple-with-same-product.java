class Solution {
    public int tupleSameProduct(int[] nums) {
        int len = nums.length;
        if (len < 4) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                pq.add(nums[i] * nums[j]);
            }
        }
        
        int answer = 0;
        int cur = pq.poll();
        int count = 1;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (cur == num) {
                count++;
            } else {
                answer += (count * (count - 1) / 2) * 8;
                cur = num;
                count = 1;
            }
        }

        return answer;
    }
}
