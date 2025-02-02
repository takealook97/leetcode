class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (i >= len - 1) {
                if (nums[i] > nums[0]) {
                    count++;
                }
            } else {
                if (nums[i] > nums[i + 1]) {
                    count++;
                }
            }
        }

        return count <= 1;
    }
}
