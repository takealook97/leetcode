class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long[] sumArr = new long[len];
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                sumArr[i] += sumArr[i - 1];
            }
            sumArr[i] += nums[i];
        }

        int answer = 0;

        for (int i = 1; i < len; i++) {
            long leftSum = sumArr[i - 1];
            long rightSum = sumArr[len - 1] - sumArr[i - 1];
            if (leftSum >= rightSum) {
                answer++;
            }
        }

        return answer;
    }
}
