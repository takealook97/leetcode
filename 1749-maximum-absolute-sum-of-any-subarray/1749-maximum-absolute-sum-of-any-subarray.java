class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int len = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, answer = 0;
        if (len == 1) {
            return Math.abs(nums[0]);
        }

        int[] sum = new int[len];
        sum[0] = nums[0];
        min = Math.min(min, sum[0]);
        max = Math.max(max, sum[0]);
        answer = Math.max(answer, nums[0]);
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
            min = Math.min(min, sum[i]);
            max = Math.max(max, sum[i]);
            answer = Math.max(answer, Math.max(Math.abs(sum[i]), Math.abs(nums[i])));
        }

        return Math.max(answer, Math.abs(max - min));
    }
}
