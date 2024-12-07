class Solution {
    static int[] nums;
    static int maxOperations;
    
    static final int LIMIT = 1000000000;

    public int minimumSize(int[] nums, int maxOperations) {
        this.nums = nums;
        this.maxOperations = maxOperations;

        int lo = 1, hi = LIMIT, mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (isPossible(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isPossible(int target) {
        int operations = 0;
        for (int num : nums) {
            if (num > target) {
                operations += (num - 1) / target;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}
