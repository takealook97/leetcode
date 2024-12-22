import java.util.*;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int qLen = queries.length;
        int[] answer = new int[qLen];
        
        int[] rightMax = new int[n];
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(heights[i], rightMax[i + 1]);
        }

        for (int i = 0; i < qLen; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int result = -1;

            int start = Math.max(a, b);

            for (int j = start; j < n; j++) {
                if (heights[j] >= heights[a] && heights[j] >= heights[b]) {
                    result = j;
                    break;
                }
            }

            answer[i] = result;
        }
        
        return answer;
    }
}
