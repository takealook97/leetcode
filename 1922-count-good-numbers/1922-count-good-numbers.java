class Solution {
    static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        return (int) ((find(5, (n + 1) / 2) * find(4, n / 2)) % MOD);
    }
    
    static long find(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
