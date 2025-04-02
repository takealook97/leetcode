class Solution {
    public long maximumTripletValue(int[] nums) {
        int len = nums.length;
        long answer = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    answer = Math.max(answer, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        return answer;
    }
}
