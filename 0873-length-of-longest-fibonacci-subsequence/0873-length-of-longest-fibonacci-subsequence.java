class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[len][len];
        int answer = 0;

        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);

                if (k >= 0 && k < j) {
                    dp[j][i] = dp[k][j] + 1;
                    answer = Math.max(answer, dp[j][i]);
                } else {
                    dp[j][i] = 2;
                }
            }
        }

        return answer >= 3 ? answer : 0;
    }
}
