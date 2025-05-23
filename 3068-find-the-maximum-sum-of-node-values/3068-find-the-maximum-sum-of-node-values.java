class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long answer = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int xor = num ^ k;
            if (xor > num) {
                answer += xor;
                count++;
            } else {
                answer += num;
            }
            min = Math.min(min, Math.abs(xor - num));
        }

        if (count % 2 == 1) {
            answer -= min;
        }

        return answer;
    }
}
