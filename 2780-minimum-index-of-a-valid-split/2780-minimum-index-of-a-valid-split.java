class Solution {
    static List<Integer> nums;

    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        this.nums = nums;
        int dom = getDominant();
        int total = 0;
        for (int num : nums) {
            if (num == dom) total++;
        }

        int left = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dom) left++;
            int l = i + 1, r = n - l;
            if (left * 2 > l && (total - left) * 2 > r) return i;
        }

        return -1;
    }

    static int getDominant() {
        int target = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                target = num;
                count = 1;
            } else if (num == target) {
                count++;
            } else {
                count--;
            }
        }
        return target;
    }
}
