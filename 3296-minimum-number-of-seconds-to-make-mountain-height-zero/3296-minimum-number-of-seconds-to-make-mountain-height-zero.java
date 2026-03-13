class Solution {
    static int mountainHeight;
    static int[] workerTimes;

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        this.mountainHeight = mountainHeight;
        this.workerTimes = workerTimes;

        long lo = 0;
        long hi = (long)1e16;
        long ans = hi;

        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;
            if (isPossible(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    static boolean isPossible(long t) {
        long sum = 0;

        for (int w : workerTimes) {
            long val = 1 + (8 * t) / w;
            long x = (long)((Math.sqrt(val) - 1) / 2);
            sum += x;

            if (sum >= mountainHeight) {
                return true;
            }
        }

        return false;
    }
}