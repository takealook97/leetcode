class Solution {
    public long countSubarrays(int[] nums, int k) {
        int len = nums.length, max = 0;
        long answer = 0L;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int lo = 0, hi = 0, count = 0;
        while (hi < len) {
            if (nums[hi] == max) {
                count++;
            }
            while (count >= k) {
                answer += (len - hi);
                if (nums[lo] == max) {
                    count--;
                }
                lo++;
            }
            hi++;
        }

        return answer;
    }
}
