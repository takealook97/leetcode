class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        
        int[] dp = new int[len];
        int[] prev = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIdx = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (maxIdx >= 0) {
            answer.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }

        Collections.reverse(answer);
        return answer;
    }
}
