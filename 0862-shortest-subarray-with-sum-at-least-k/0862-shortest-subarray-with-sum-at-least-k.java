class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        long[] sumArr = new long[len + 1];
        
        for (int i = 1; i <= len; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i - 1];
        }

        int lo = 0;
        int min = Integer.MAX_VALUE;

        for (int hi = 0; hi <= len; hi++) {
            while (lo < hi && sumArr[hi] - sumArr[lo] >= k) {
                min = Math.min(min, hi - lo);
                lo++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
