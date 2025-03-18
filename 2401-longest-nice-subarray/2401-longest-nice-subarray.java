class Solution {
    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int lo = 0, hi = 1, orResult = nums[0], sum = nums[0], answer = 1;
        while (hi < len) {
            int tempResult = orResult | nums[hi];
            int tempSum = sum + nums[hi];
            if (tempResult == tempSum) {
                answer = Math.max(answer, hi - lo + 1);
                orResult = tempResult;
                sum = tempSum;
                hi++;
            } else {
                orResult ^= nums[lo];
                sum -= nums[lo];
                lo++;
            }
        }

        return answer;
    }
}