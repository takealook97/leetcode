class Solution {
    static int len;
    static int[] nums;

    public int partitionArray(int[] nums, int k) {
        len = nums.length;
        Arrays.sort(nums);
        this.nums = nums;

        int answer = 0;
        int idx = 0;

        while (idx < len) {
            idx = upperBound(idx, nums[idx] + k);
            answer++;
        }

        return answer;
    }

    static int upperBound(int lo, int target) {
        int hi = len - 1, mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
