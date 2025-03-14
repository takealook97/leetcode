class Solution {
    static int n, len, answer;
    static long k;
    static int[] candies;

    public int maximumCandies(int[] candies, long k) {
        n = candies.length;
        this.k = k;
        answer = 0;
        Arrays.sort(candies);
        this.candies = candies;

        int lo = 1;
        int hi = candies[n - 1];
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isPossible(mid, lowerBound(mid))) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }

    static int lowerBound(int target) {
        int lo = 0, hi = candies.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (candies[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    static boolean isPossible(int piece, int start) {
        long count = 0;
        for (int i = start; i < n; i++) {
            count += (candies[i] / piece);
            if (count >= k) {
                answer = Math.max(answer, piece);
                return true;
            }
        }
        
        return false;
    }
}