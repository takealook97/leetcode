import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int maxPrice = items[items.length - 1][0];
        int[] dp = new int[maxPrice + 1];
        
        int maxBeauty = 0;
        for (int i = 0; i < items.length; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            dp[items[i][0]] = maxBeauty;
        }

        for (int i = 1; i <= maxPrice; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > maxPrice) {
                answer[i] = dp[maxPrice];
            } else if (queries[i] < items[0][0]) {
                answer[i] = 0;
            } else {
                answer[i] = dp[queries[i]];
            }
        }

        return answer;
    }
}
