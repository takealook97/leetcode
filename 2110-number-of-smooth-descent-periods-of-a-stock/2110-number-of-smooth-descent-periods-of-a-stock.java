class Solution {
    public long getDescentPeriods(int[] prices) {
        int len = prices.length;
        int lo = 0, hi = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (hi < len) {
            if (lo == hi) {
                hi++;
                continue;
            }

            if (prices[hi] + 1 == prices[hi - 1]) {
                hi++;
            } else {
                list.add(hi - lo);
                lo = hi;
            }
        }
        list.add(hi - lo);

        long answer = 0;
        for (int n : list) {
            answer += (long) n * (n + 1) / 2;
        }

        return answer;
    }
}
