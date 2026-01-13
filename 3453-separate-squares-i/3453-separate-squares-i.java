class Solution {
    public double separateSquares(int[][] squares) {
        double sum = 0;
        double lo = 1e18, hi = -1e18;

        for (int[] square : squares) {
            double y = square[1], l = square[2];
            sum += l * l;
            lo = Math.min(lo, y);
            hi = Math.max(hi, y + l);
        }

        for (int i = 0; i < 80; i++) {
            double mid = lo + (hi - lo) / 2.0;
            double below = 0;

            for (int[] square : squares) {
                double y = square[1], l = square[2];
                if (mid <= y) {
                    continue;
                }
                if (mid >= y + l) {
                    below += l * l;
                } else {
                    below += l * (mid - y);
                }
            }

            if (below * 2 < sum) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}