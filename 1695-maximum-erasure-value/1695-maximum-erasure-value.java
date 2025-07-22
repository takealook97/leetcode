class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int lo = 0, hi = 0;

        int[] count = new int[10];
        int answer = 0, sum = 0;

        while (lo < len && hi < len) {
            if (count[nums[hi]] == 0) {
                count[nums[hi]]++;
                sum += nums[hi];
                hi++;
            } else {
                answer = Math.max(answer, sum);
                count[nums[hi]]++;
                while (lo < hi) {
                    if (nums[lo] == nums[hi]) {
                        count[nums[lo]]--;
                        lo++;
                        break;
                    }
                    sum -= nums[lo];
                    count[nums[lo]]--;
                    lo++;
                }
                hi++;
            }
        }

        answer = Math.max(answer, sum);

        return answer;
    }
}