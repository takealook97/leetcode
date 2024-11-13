class Solution {
    static int len;
    static int[] nums;

    public long countFairPairs(int[] nums, int lower, int upper) {
        len = nums.length;
        if (len <= 1) {
            return 0;
        }

        this.nums = nums;
        Arrays.sort(nums);

        long answer = 0;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < len - 1; i++) {
            int lowerIdx = lowerBound(i + 1, lower - nums[i]);
            int upperIdx = upperBound(i + 1, upper - nums[i]);

            if (lowerIdx >= upperIdx) {
                continue;
            }
            
            answer += (upperIdx - lowerIdx);
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
