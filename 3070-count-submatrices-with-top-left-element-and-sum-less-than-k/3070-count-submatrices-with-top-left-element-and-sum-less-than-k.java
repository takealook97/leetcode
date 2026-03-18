class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int answer = 0;
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = grid[i - 1][j - 1] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
                if (arr[i][j] <= k) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
