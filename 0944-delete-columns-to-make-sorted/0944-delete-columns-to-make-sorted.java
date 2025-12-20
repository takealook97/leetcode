class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length(), m = strs.length;
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = strs[j].charAt(i);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            char[] temp = Arrays.copyOf(arr[i], m);
            Arrays.sort(temp);
            for (int j = 0; j < m; j++) {
                if (temp[j] != arr[i][j]) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
