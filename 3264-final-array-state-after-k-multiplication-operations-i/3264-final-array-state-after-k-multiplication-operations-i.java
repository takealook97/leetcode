class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int len = nums.length;
        int min, idx;
        while (k-- > 0) {
            min = Integer.MAX_VALUE;
            idx = -1;
            for (int i = len - 1; i >= 0; i--) {
                if (nums[i] <= min) {
                    min = nums[i];
                    idx = i;
                }
            }

            nums[idx] *= multiplier;
        }

        return nums;
    }
}
