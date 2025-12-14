class Solution {
    static int len;
    static int[] arr;

    static final char SEAT = 'S', PLANT = 'P';
    static final int MOD = 1000000007;

    public int numberOfWays(String corridor) {
        len = corridor.length();
        arr = new int[len];
        arr[0] = corridor.charAt(0) == SEAT ? 1 : 0;
        for (int i = 1; i < len; i++) {
            arr[i] += arr[i - 1] + (corridor.charAt(i) == SEAT ? 1 : 0);
        }

        int total = arr[len - 1];
        if (total == 0 || (total & 1) == 1) {
            return 0;
        }

        long answer = 1;
        int section = total / 2;

        for (int k = 1; k < section; k++) {
            int right = lowerBound(k * 2);
            int next = lowerBound(k * 2 + 1);
            answer = (answer * (next - right)) % MOD;
        }

        return (int) answer;
    }

    static int lowerBound(int target) {
        int lo = 0, hi = len - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    static int upperBound(int target) {
        int lo = 0, hi = len - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
