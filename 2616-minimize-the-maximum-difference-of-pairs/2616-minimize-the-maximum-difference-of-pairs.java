class Solution {
    static int[] nums;
    static int p;

    public int minimizeMax(int[] nums, int p) {
        this.nums = nums;
        this.p = p;
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    static boolean isPossible(int maxDiff) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (Math.abs(nums[i] - nums[i + 1]) <= maxDiff) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >= p;
    }
}
