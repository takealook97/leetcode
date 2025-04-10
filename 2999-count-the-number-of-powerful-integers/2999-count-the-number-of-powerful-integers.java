class Solution {
    static final int SIZE = 16;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        int[] loArr = new int[SIZE];
        int[] hiArr = new int[SIZE];
        int idx = 0;
        long tmp = start;
        while (tmp > 0) {
            loArr[idx++] = (int)(tmp % 10);
            tmp /= 10;
        }
        idx = 0;
        tmp = finish;
        while (tmp > 0) {
            hiArr[idx++] = (int)(tmp % 10);
            tmp /= 10;
        }

        long base = Long.parseLong(s);
        if (base > finish) return 0;

        long p = 1;
        for (int i = 0; i < s.length(); i++) p *= 10;

        long lowPrefix = 0;
        if (start > base) lowPrefix = (start - base + (p - 1)) / p;
        long highPrefix;
        if (finish < base) return 0; 
        else highPrefix = (finish - base) / p;

        long cntHi = countUpTo(highPrefix, limit);
        long cntLo = countUpTo(lowPrefix - 1, limit);

        return Math.max(0, cntHi - cntLo);
    }

    static long countUpTo(long n, int limit) {
        if (n < 0) return 0;
        String s = Long.toString(n);
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            for (int c = 0; c < digit; c++) {
                if (c <= limit) ans += (long)Math.pow(limit + 1, s.length() - 1 - i);
            }
            if (digit > limit) break;
            if (i == s.length() - 1 && digit <= limit) ans++;
        }
        return ans;
    }
}
