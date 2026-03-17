class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int answer = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0 && i > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            
            int[] cur = matrix[i].clone();
            Arrays.sort(cur);
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, cur[j] * (n - j));
            }
        }
        
        return answer;
    }
}
