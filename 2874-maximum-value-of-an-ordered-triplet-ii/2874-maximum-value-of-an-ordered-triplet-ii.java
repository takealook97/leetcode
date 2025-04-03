class Solution {
    public long maximumTripletValue(int[] nums) {
        long answer = 0;
        int len = nums.length;
        int[] lo = new int[len];
        int[] hi = new int[len];
        for (int i = 1; i < len; i++) {
            lo[i] = Math.max(lo[i - 1], nums[i - 1]);
            hi[len - 1 - i] = Math.max(hi[len - i], nums[len - i]);
        }

        for (int i = 1; i < len - 1; i++) {
            answer = Math.max(answer, (long) (lo[i] - nums[i]) * hi[i]);
        }

        return answer;
    }
}
