class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long[] sumArr = new long[len + 1];
        for (int i = 1; i <= len; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i - 1];
        }

        long answer = Long.MIN_VALUE;
        long[] minArr = new long[k];
        boolean[] used = new boolean[k];
        for (int i = 0; i < k; i++) {
            minArr[i] = 0;
            used[i] = false;
        }

        for (int i = 0; i <= len; i++) {
            int g = i % k;
            if (used[g]) {
                answer = Math.max(answer, sumArr[i] - minArr[g]);
            }
            if (!used[g] || sumArr[i] < minArr[g]) {
                minArr[g] = sumArr[i];
                used[g] = true;
            }
        }

        return answer;
    }
}
