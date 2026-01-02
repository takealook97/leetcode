class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2, cur = nums[0], count = 0;
        for (int num : nums) {
            if (num == cur) {
                count++;
            } else {
                if (count == n) {
                    return cur;
                } else {
                    count = 1;
                    cur = num;
                }
            }
        }

        return cur;
    }
}
