class Solution {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int len = prices.length;
        long[] profitSum = new long[len + 1];
        long[] priceSum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            profitSum[i + 1] = profitSum[i] + (long) prices[i] * strategy[i];
            priceSum[i + 1] = priceSum[i] + prices[i];
        }

        long answer = profitSum[len], lo, hi, changeProfit;
        for (int i = k - 1; i < len; i++) {
            lo = profitSum[i - k + 1];
            hi = profitSum[len] - profitSum[i + 1];
            changeProfit = priceSum[i + 1] - priceSum[i - k / 2 + 1];
            answer = Math.max(answer, lo + hi + changeProfit);
        }

        return answer;
    }
}