class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] sum = new int[len];

        for (int[] query : queries) {
            sum[query[0]]++;
            if (query[1] < len - 1) {
                sum[query[1] + 1]--;
            }
        }

        if (nums[0] > sum[0]) return false;
        for (int i = 1; i < len; i++) {
            sum[i] += sum[i - 1];
            if (nums[i] > sum[i]) return false;
        }

        return true;
    }
}
