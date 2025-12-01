class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int len = batteries.length;
        Arrays.sort(batteries);

        long lo = 0, hi = 0;
        for (int b : batteries) {
            hi += b;
        }
        hi /= n;

        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            long sum = 0;
            for (int i = len - 1; i >= 0; i--) {
                sum += Math.min(batteries[i], mid);
            }
            if (sum >= mid * n) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
