class Solution {
    static int[] nums;
    static int k;

    public int minCapability(int[] nums, int k) {
        this.nums = nums;
        this.k = k;

        int lo = 1;
        int hi = (int) 1e9;
        int answer = hi;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer;
    }

    static boolean isPossible(int capability) {
        int count = 0;
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] <= capability) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        return count >= k;
    }
}
