class Solution {
    public long countSubarrays(int[] nums, long k) {
        int len = nums.length;
        long answer = 0L;

        long[] sumArr = new long[len];
        sumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
        }

        int curLen = 1;
        int lo = 0, hi = 0;
        long cur = 0L;
        while (lo <= hi && lo < len) {
            if (lo == 0) {
                cur = nums[hi] * (hi + 1);
            } else {
                cur = (nums[hi] - nums[lo - 1]) * (hi - lo + 1);
            }

            if (cur < k) {
                answer++;

                if (hi < len - 1) {
                    hi++;
                } else {
                    lo++;
                }
            } else {
                if (lo < hi) {
                    lo++;
                } else {
                    lo++;
                    hi++;
                }
            }
        }

        return answer;
    }
}
