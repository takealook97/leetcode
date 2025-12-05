class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int len = nums.length, accum = 0, answer = 0;
        for (int i = 0; i < len - 1; i++) {
            accum += nums[i];
            if (Math.abs(sum - 2 * accum) % 2 == 0) {
                answer++;
            }
        }

        return answer;
    }
}
