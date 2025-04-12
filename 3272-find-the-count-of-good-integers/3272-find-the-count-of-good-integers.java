class Solution {
    static int n, k;
    static boolean isEven;
    static java.util.Set<String> set;
    static long[] factorial;
    static long answer;

    public long countGoodIntegers(int n, int k) {
        this.n = n;
        this.k = k;
        isEven = (n % 2 == 0);
        set = new java.util.HashSet<>();
        factorial = new long[n + 1];
        answer = 0L;
        find(0L, 0);
        factorial[0] = 1L;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        for (String s : set) {
            accumulate(s);
        }
        return answer;
    }

    static void find(long left, int depth) {
        if (depth >= n / 2) {
            setPalindrom(left);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (left == 0L && i == 0) {
                continue;
            }
            find(left * 10 + i, depth + 1);
        }
    }

    static void setPalindrom(long num) {
        long left = num * (long) Math.pow(10, n / 2);
        long right = 0;
        long tmp = num;
        for (int i = n / 2 - 1; i >= 0; i--) {
            right += (tmp % 10) * (long) Math.pow(10, i);
            tmp /= 10;
        }
        if (isEven) {
            long pal = left + right;
            if (pal % k == 0) {
                saveNumber(pal);
            }
        } else {
            left *= 10;
            for (int i = 0; i <= 9; i++) {
                if (left == 0L && i == 0) {
                    continue;
                }
                long mid = (long) i * (long) Math.pow(10, n / 2);
                long pal = left + mid + right;
                if (pal % k == 0) {
                    saveNumber(pal);
                }
            }
        }
    }

    static void saveNumber(long val) {
        String s = String.valueOf(val);
        if (s.length() < n) {
            return;
        }
        char[] arr = s.toCharArray();
        java.util.Arrays.sort(arr);
        set.add(new String(arr));
    }

    static void accumulate(String sortedDigits) {
        int[] cnt = new int[10];
        for (char c : sortedDigits.toCharArray()) {
            cnt[c - '0']++;
        }
        if (n == 1) {
            long tot = (long) (1 - cnt[0]) * factorial[0];
            for (int x : cnt) {
                tot /= factorial[x];
            }
            answer += tot;
            return;
        }
        int zeroCount = cnt[0];
        if (n - zeroCount <= 0) {
            return;
        }
        long tot = (long) (n - zeroCount) * factorial[n - 1];
        for (int c : cnt) {
            tot /= factorial[c];
        }
        answer += tot;
    }
}
