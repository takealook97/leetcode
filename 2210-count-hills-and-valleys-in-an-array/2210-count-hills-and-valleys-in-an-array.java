class Solution {
    public int countHillValley(int[] nums) {
        int len = nums.length;
        int answer = 0;

        int left, right;
        int lo, hi;
        int prev = nums[0];
        for (int i = 1; i < len - 1; i++) {
            if (prev == nums[i]) {
                continue;
            }
            left = 0;
            right = 0;
            lo = i - 1;
            hi = i + 1;

            while (0 <= lo) {
                if (nums[lo] == nums[i]) {
                    lo--;
                    if (lo < 0) {
                        left = 0;
                    }
                } else if (nums[lo] < nums[i]) {
                    left = 1;
                    break;
                } else {
                    left = -1;
                    break;
                }
            }

            while (hi < len) {
                if (nums[hi] == nums[i]) {
                    hi++;
                    if (hi >= len) {
                        right = 0;
                    }
                } else if (nums[hi] > nums[i]) {
                    right = -1;
                    break;
                } else {
                    right = 1;
                    break;
                }
            }

            if (left != 0 && right != 0 && left == right) {
                answer++;
            }

            prev = nums[i];
        }

        return answer;
    }
}
