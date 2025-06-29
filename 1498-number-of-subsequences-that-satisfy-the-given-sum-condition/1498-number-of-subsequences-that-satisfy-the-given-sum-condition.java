class Solution {
    static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);

        int[] arr = new int[len];
        arr[0] = 1;
        for (int i = 1; i < len; i++) {
            arr[i] = (arr[i - 1] * 2) % MOD;
        }

        int answer = 0;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            if (nums[lo] + nums[hi] <= target) {
                answer = (answer + arr[hi - lo]) % MOD;
                lo++;
            } else {
                hi--;
            }
        }

        return answer;
    }
}
