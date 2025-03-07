class Solution {
    static int len, min;
    static boolean[] isPrime;
    static int[] answer;

    public int[] closestPrimes(int left, int right) {
        answer = new int[2];
        setPrimes(right);

        int prev = 0, min = 0;
        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                if (prev == 0) {
                    prev = num;
                } else {
                    if (min == 0 || min > num - prev) {
                        min = num - prev;
                        answer[0] = prev;
                        answer[1] = num;
                    }
                    prev = num;
                }
            }
        }
        if (answer[0] == 0) {
            Arrays.fill(answer, -1);
            return answer;
        }

        return answer;
    }

    static void setPrimes(int limit) {
        isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
