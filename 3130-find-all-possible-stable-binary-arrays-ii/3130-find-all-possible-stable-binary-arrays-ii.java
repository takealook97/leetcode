class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][] dp0 = new long[zero + 1][one + 1];
        long[][] dp1 = new long[zero + 1][one + 1];
        long[][] sumArr1 = new long[zero + 1][one + 1];
        long[][] sumArr2 = new long[zero + 1][one + 1];

        dp0[0][0] = dp1[0][0] = 1;

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                if (i > 0) {
                    int l = Math.max(0, i - limit);
                    int r = i - 1;

                    long val = sumArr2[r][j];
                    if (l > 0) val = (val - sumArr2[l - 1][j] + MOD) % MOD;

                    dp0[i][j] = val;
                }

                if (j > 0) {
                    int l = Math.max(0, j - limit);
                    int r = j - 1;

                    long val = sumArr1[i][r];
                    if (l > 0) val = (val - sumArr1[i][l - 1] + MOD) % MOD;

                    dp1[i][j] = val;
                }

                sumArr1[i][j] = ((j > 0 ? sumArr1[i][j - 1] : 0) + dp0[i][j]) % MOD;
                sumArr2[i][j] = ((i > 0 ? sumArr2[i - 1][j] : 0) + dp1[i][j]) % MOD;
            }
        }

        return (int)((dp0[zero][one] + dp1[zero][one]) % MOD);
    }
}