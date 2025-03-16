class Solution {
    static int len;
    static int[] ranks;
    static int cars;
    
    public long repairCars(int[] ranks, int cars) {
        this.ranks = ranks;
        this.cars = cars;
        len = ranks.length;
        Arrays.sort(ranks);

        long lo = 1;
        long hi = (long) ranks[0] * cars * cars;
        long mid;
        
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isPossible(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    static boolean isPossible(long time) {
        long sum = 0;
        for (int rank : ranks) {
            sum += (long) Math.sqrt((double) time / rank);
            if (sum >= cars) {
                return true;
            }
        }
        return false;
    }
}
