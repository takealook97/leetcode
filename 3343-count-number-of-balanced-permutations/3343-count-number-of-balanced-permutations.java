public class Solution {
    static int[] cnt = new int[10];
    static long[] fac, ifac;
    
    static final int MOD = 1_000_000_007;

    public int countBalancedPermutations(String num) {
        int length = num.length();
        for (int i = 0; i < 10; i++) cnt[i] = 0;
        int totalSum = 0;
        for (char c : num.toCharArray()) {
            int d = c - '0';
            cnt[d]++;
            totalSum += d;
        }
        if (totalSum % 2 != 0) return 0;
        String midNum = num;

        int halfSum = totalSum / 2;
        int evenSlots = (length + 1) / 2;
        int oddSlots = length - evenSlots;

        initFactorials(length);
        long[][] dp = new long[evenSlots + 1][halfSum + 1];
        dp[0][0] = 1;

        for (int d = 0; d < 10; d++) {
            int c = cnt[d];
            if (c == 0) continue;
            long[] weight = new long[c + 1];
            for (int x = 0; x <= c; x++) {
                weight[x] = ifac[x] * ifac[c - x] % MOD;
            }
            long[][] ndp = new long[evenSlots + 1][halfSum + 1];
            for (int u = 0; u <= evenSlots; u++) {
                for (int s = 0; s <= halfSum; s++) {
                    long v = dp[u][s];
                    if (v == 0) continue;
                    for (int x = 0; x <= c && u + x <= evenSlots && s + d * x <= halfSum; x++) {
                        ndp[u + x][s + d * x] = (ndp[u + x][s + d * x] + v * weight[x]) % MOD;
                    }
                }
            }
            dp = ndp;
        }

        long result = dp[evenSlots][halfSum];
        result = result * fac[evenSlots] % MOD * fac[oddSlots] % MOD;
        return (int) result;
    }

    static void initFactorials(int n) {
        fac = new long[n + 1];
        ifac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) fac[i] = fac[i - 1] * i % MOD;
        ifac[n] = modInv(fac[n]);
        for (int i = n; i > 0; i--) ifac[i - 1] = ifac[i] * i % MOD;
    }

    static long modInv(long x) {
        long res = 1;
        int p = MOD - 2;
        while (p > 0) {
            if ((p & 1) == 1) res = res * x % MOD;
            x = x * x % MOD;
            p >>= 1;
        }
        return res;
    }
}
