class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long answer = 0, sum = 0;
        int[] count = new int[100001];
        int lo = 0;

        for (int hi = 0; hi < len; hi++) {
            count[nums[hi]]++;
            sum += nums[hi];

            while (count[nums[hi]] > 1) {
                count[nums[lo]]--;
                sum -= nums[lo];
                lo++;
            }

            if (hi - lo + 1 == k) {
                answer = Math.max(answer, sum);
                count[nums[lo]]--;
                sum -= nums[lo];
                lo++;
            }
        }

        return answer;
    }
}
