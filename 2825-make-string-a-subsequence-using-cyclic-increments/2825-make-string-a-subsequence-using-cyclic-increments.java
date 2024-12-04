class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int N = str1.length(), M = str2.length();

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = (int) str1.charAt(i);
            if (arr[i][0] == 'z') {
                arr[i][1] = (int) 'a';
            } else {
                arr[i][1] = arr[i][0] + 1;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int alphabet = (int) str2.charAt(idx);
            if (alphabet == arr[i][0] || alphabet == arr[i][1]) {
                idx++;
                if (idx >= M) {
                    return true;
                }
            }
        }

        return false;
    }
}
