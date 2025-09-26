class Solution {
    static int len;
    static int[] nums;

    public int triangleNumber(int[] nums) {
        len = nums.length;
        if (len < 3) {
            return 0;
        }

        Arrays.sort(nums);
        this.nums = nums;
        
        int answer = 0;
        for (int lo = 0; lo < len - 2; lo++) {
            for (int hi = lo + 1; hi < len - 1; hi++) {
                int idx = lowerBound(hi + 1, nums[lo] + nums[hi]);
                if (hi != idx - 1) {
                    idx--;
                    answer += (idx - hi);
                }
            }
        }

        return answer;
    }

    static int lowerBound(int lo, int target) {
        int hi = len - 1, mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
