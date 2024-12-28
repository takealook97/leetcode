class Solution {
    static boolean[] visited;

    static class Range implements Comparable<Range> {
        int from, to, sum;
        public Range(int from, int to, int sum) {
            this.from = from;
            this.to = to;
            this.sum = sum;
        }

        @Override
        public int compareTo(Range o) {
            if(this.sum == o.sum) {
                return this.from - o.from;
            }
            return o.sum - this.sum;
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        visited = new boolean[nums.length];
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Range[] subs = new Range[n - k + 1];
        for (int i = 0; i + k <= n; i++) {
            subs[i] = new Range(i, i + k - 1, prefix[i + k] - prefix[i]);
        }

        int[] left = new int[subs.length];
        int idx = 0;
        for (int i = 0; i < subs.length; i++) {
            if (subs[i].sum > subs[idx].sum) {
                idx = i;
            }
            left[i] = idx;
        }

        int[] right = new int[subs.length];
        idx = subs.length - 1;
        for (int i = subs.length - 1; i >= 0; i--) {
            if (subs[i].sum >= subs[idx].sum) {
                idx = i;
            }
            right[i] = idx;
        }

        int max = 0;
        int[] answer = new int[3];
        for (int m = k; m <= n - 2 * k; m++) {
            int l = left[m - k];
            int r = right[m + k];
            int total = subs[l].sum + subs[m].sum + subs[r].sum;
            if (total > max) {
                max = total;
                answer[0] = subs[l].from;
                answer[1] = subs[m].from;
                answer[2] = subs[r].from;
            }
        }

        return answer;
    }
}
