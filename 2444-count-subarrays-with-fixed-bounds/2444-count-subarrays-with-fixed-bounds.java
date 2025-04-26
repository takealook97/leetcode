class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int len = nums.length;
        int minIdx = -1, maxIdx = -1, bad = -1;
        long answer = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < minK || nums[i] > maxK) bad = i;
            if (nums[i] == minK) minIdx = i;
            if (nums[i] == maxK) maxIdx = i;
            answer += Math.max(0, Math.min(minIdx, maxIdx) - bad);
        }

        return answer;
    }
}
