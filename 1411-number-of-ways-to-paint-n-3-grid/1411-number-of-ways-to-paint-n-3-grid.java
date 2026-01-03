class Solution {
    static final int MOD = 1000000007;

    public int numOfWays(int n) {
        long x = 6;
        long y = 6;

        for (int i = 2; i <= n; i++) {
            long nextX = (x * 3 + y * 2) % MOD;
            long nextY = (x * 2 + y * 2) % MOD;
            x = nextX;
            y = nextY;
        }

        return (int)((x + y) % MOD);
    }
}
