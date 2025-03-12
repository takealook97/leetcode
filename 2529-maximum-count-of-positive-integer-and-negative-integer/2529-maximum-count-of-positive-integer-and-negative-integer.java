class Solution {
    public int maximumCount(int[] nums) {
        int negativeCount = 0, zeroCount = 0;
        for (int num : nums) {
            if (num < 0) {
                negativeCount++;
            } else if (num == 0) {
                zeroCount++;
            } else {
                break;
            }
        }

        return Math.max(negativeCount, nums.length - zeroCount - negativeCount);
    }
}
