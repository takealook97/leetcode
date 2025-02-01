class Solution {
    public boolean isArraySpecial(int[] nums) {
        int len = nums.length;
        if (len == 0) return true;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }

        return true;
    }
}
