class Solution {
    public boolean isTrionic(int[] nums) {
        int len = nums.length;
        int a = 0, b = 0;
        boolean increasing = true;
        if (nums[1] <= nums[0]) {
            return false;
        }

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                if (increasing) {
                    continue;
                }
                a++;
                increasing = false;
            } else if (nums[i] < nums[i - 1]) {
                if (!increasing) {
                    continue;
                }
                b++;
                increasing = true;
            } else {
                return false;
            }
        }

        System.out.println(a + " " + b);
        return a + b == 2;
    }
}
