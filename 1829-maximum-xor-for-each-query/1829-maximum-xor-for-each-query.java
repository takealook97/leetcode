class Solution {
    static int len;
    static int[] count, answer;

    static final int LIMIT = 20;

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        len = nums.length;
        count = new int[LIMIT];
        answer = new int[len];

        setCount(nums);
        find(nums, maximumBit);

        return answer;
    }

    static void setCount(int[] nums) {
        for (int num : nums) {
            for (int i = 0; i < LIMIT; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
    }

    static void find(int[] nums, int maximumBit) {
        for (int i = len - 1; i >= 0; i--) {
            for (int j = maximumBit - 1; j >= 0; j--) {
                if (count[j] % 2 == 0) {
                    answer[len - 1 - i] += Math.pow(2, j);
                }
            }

            for (int j = 0; j < LIMIT; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    count[j]--;
                }
            }
        }
    }
}
