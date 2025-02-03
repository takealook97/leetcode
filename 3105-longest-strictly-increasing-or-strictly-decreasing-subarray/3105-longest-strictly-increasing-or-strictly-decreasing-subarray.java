class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len = nums.length;
        if (len == 1) return 1;
        int answer = 0;
        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            answer = Math.max(answer, count);
        }

        count = 1;

        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] < nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
