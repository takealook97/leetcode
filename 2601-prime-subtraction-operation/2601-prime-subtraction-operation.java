class Solution {
    static int len, primeCount;
    static int[] primes;

    static final int LIMIT = 1000;

    public boolean primeSubOperation(int[] nums) {
        len = nums.length;
        setPrime();

        int prev = 0;
        for (int i = 0; i < len; i++) {
            int cur = -1;
            for (int j = primeCount; j >= 0; j--) {
                if (0 < nums[i] - primes[j] && prev < nums[i] - primes[j]) {
                    cur = nums[i] - primes[j];
                    prev = cur;
                    break;
                }
            }

            if (0 < cur) {
                nums[i] = cur;
            } else {
                return false;
            }
        }

        return true;
    }

    static void setPrime() {
        boolean[] isPrime = new boolean[LIMIT + 1];
        primeCount = 0;

        for (int i = 2; i <= LIMIT; i++) {
            if (!isPrime[i]) {
                primeCount++;
                for (int j = i * 2; j <= LIMIT; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        primes = new int[primeCount + 1];
        int idx = 1;
        for (int i = 2; i <= LIMIT; i++) {
            if (!isPrime[i]) {
                primes[idx++] = i;
            }
        }
    }
}
