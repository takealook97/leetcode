class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int answer = 0;

        for (int hi = 0; hi < nums.length; hi++) {
            while (nums[hi] - nums[lo] > 2 * k) {
                lo++;
            }
            answer = Math.max(answer, hi - lo + 1);
        }

        return answer;
    }
}
