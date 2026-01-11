class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] h = new int[m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            }
            answer = Math.max(answer, maxHist(h));
        }

        return answer;
    }

    static int maxHist(int[] h) {
        int n = h.length;
        int[] arr = new int[n + 1];
        int top = 0, result = 0;

        for (int i = 0; i <= n; i++) {
            int cur = (i == n ? 0 : h[i]);
            while (top > 0 && h[arr[top - 1]] > cur) {
                int height = h[arr[--top]];
                int width = top == 0 ? i : i - arr[top - 1] - 1;
                result = Math.max(result, height * width);
            }
            arr[top++] = i;
        }

        return result;
    }
}
