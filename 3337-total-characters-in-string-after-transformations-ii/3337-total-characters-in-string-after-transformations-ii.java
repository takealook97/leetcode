class Solution {
    static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int n = 26;
        long[] arr = new long[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        long[][] mat = new long[n][n];
        for (int i = 0; i < n; i++) {
            int cnt = nums.get(i);
            for (int j = 1; j <= cnt; j++) {
                mat[(i + j) % 26][i] = (mat[(i + j) % 26][i] + 1) % MOD;
            }
        }

        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1;

        while (t > 0) {
            if ((t & 1) == 1) result = multiply(result, mat);
            mat = multiply(mat, mat);
            t >>= 1;
        }

        long answer = 0;
        long[] finalArr = new long[26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                finalArr[i] = (finalArr[i] + result[i][j] * arr[j]) % MOD;
            }
            answer = (answer + finalArr[i]) % MOD;
        }

        return (int) answer;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}
