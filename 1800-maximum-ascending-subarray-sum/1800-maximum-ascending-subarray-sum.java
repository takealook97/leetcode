class Solution {
    public int maxAscendingSum(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        if (len == 1) {
            return nums[0];
        }
        int answer = sum;

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
