class Solution {
    static int len, target, answer;
    static int[] nums;

    public int findTargetSumWays(int[] nums, int target) {
        len = nums.length;
        this.nums = nums;
        this.target = target;
        answer = 0;

        find(0, 0);

        return answer;
    }

    static void find(int sum, int idx) {
        if (idx >= len) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        find (sum + nums[idx], idx + 1);
        find (sum - nums[idx], idx + 1);
    }
}