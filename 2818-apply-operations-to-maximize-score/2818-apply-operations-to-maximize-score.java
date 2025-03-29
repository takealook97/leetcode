class Solution {
    static int len;
    static boolean[] isPrime;
    static int[] primeScores;

    static final int SIZE = 100000, MOD = 1_000_000_007;

    public int maximumScore(List<Integer> nums, int k) {
        isPrime = new boolean[SIZE + 1];
        setPrime();

        len = nums.size();
        primeScores = new int[len];
        for (int i = 0; i < len; i++) {
            primeScores[i] = getPrimeScore(nums.get(i));
        }

        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && primeScores[stack.peek()] <= primeScores[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len - i : stack.peek() - i;
            stack.push(i);
        }

        Integer[] indices = new Integer[len];
        for (int i = 0; i < len; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> Integer.compare(nums.get(b), nums.get(a)));

        long score = 1;

        for (int i : indices) {
            long count = (long) left[i] * right[i];
            if (count <= k) {
                score = score * modPow(nums.get(i), count, MOD) % MOD;
                k -= count;
            } else {
                score = score * modPow(nums.get(i), k, MOD) % MOD;
                break;
            }
        }

        return (int) score;
    }

    static void setPrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= SIZE; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= SIZE; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static int getPrimeScore(int num) {
        int score = 0;
        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i] && num % i == 0) {
                score++;
                while (num % i == 0) {
                    num /= i;
                }
            }
        }

        if (num > 1) {
            score++;
        }

        return score;
    }

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
