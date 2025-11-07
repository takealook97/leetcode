class Solution {
    static int len, amount;
    static long k;
    static int[] stations;
    static long[] sumArr;
    static long[] diff;
    static final long LIMIT = (long) 1e14;

    public long maxPower(int[] stations, int r, int k) {
        len = stations.length;
        amount = r;
        this.k = k;
        this.stations = stations;
        sumArr = new long[len];
        diff = new long[len];

        for (int i = 0; i < len; i++) {
            setDiff(i);
        }

        for (int i = 1; i < len; i++) {
            sumArr[i] += sumArr[i - 1];
        }

        long lo = 0, hi = LIMIT, answer = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (isPossible(mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }

    static void setDiff(int idx) {
        int lo = idx - amount >= 0 ? idx - amount : 0;
        int hi = idx + amount + 1;

        sumArr[lo] += stations[idx];
        if (hi < len) {
            sumArr[hi] -= stations[idx];
        }
    }

    static boolean isPossible(long target) {
        long used = 0, cur = 0;
        Arrays.fill(diff, 0L);

        for (int i = 0; i < len; i++) {
            cur += diff[i];
            long now = sumArr[i] + cur;

            if (now < target) {
                long need = target - now;
                used += need;

                if (used > k) {
                    return false;
                }

                cur += need;
                int hi = i + amount * 2 + 1;

                if (hi < len) {
                    diff[hi] -= need;
                }
            }
        }

        return true;
    }
}
