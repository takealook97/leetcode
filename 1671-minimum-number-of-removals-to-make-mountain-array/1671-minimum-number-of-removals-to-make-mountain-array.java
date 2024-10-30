class Solution {
    static int N;
    static int[] lisUpper, lisLower;

    public int minimumMountainRemovals(int[] nums) {
        N = nums.length;
        lisUpper = new int[N];
        lisLower = new int[N];
        Arrays.fill(lisUpper, 1);
        Arrays.fill(lisLower, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && lisUpper[i] < lisUpper[j] + 1) {
                    lisUpper[i] = lisUpper[j] + 1;
                }
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if(nums[j] < nums[i] && lisLower[i] < lisLower[j] + 1) {
                    lisLower[i] = lisLower[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i < N - 1; i++) {
            if (lisUpper[i] > 1 && lisLower[i] > 1) {
                max = Math.max(max, lisUpper[i] + lisLower[i] - 1);
            }
        }

        return N - max;
    }
}
