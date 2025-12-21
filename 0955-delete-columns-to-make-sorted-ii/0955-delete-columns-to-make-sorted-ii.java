class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length(), m = strs.length;
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = strs[j].charAt(i);
            }
        }

        boolean[] sorted = new boolean[m - 1];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            boolean bad = false;
            for (int j = 0; j < m - 1; j++) {
                if (!sorted[j] && arr[i][j] > arr[i][j + 1]) {
                    bad = true;
                    break;
                }
            }
            if (bad) {
                answer++;
                continue;
            }
            for (int j = 0; j < m - 1; j++) {
                if (!sorted[j] && arr[i][j] < arr[i][j + 1]) {
                    sorted[j] = true;
                }
            }
        }

        return answer;
    }
}
