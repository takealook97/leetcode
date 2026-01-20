class Solution {
    static Info[] arr;

    static class Info implements Comparable<Info> {
        int idx, val;

        public Info(int idx) {
            this.idx = idx;
            this.val = idx | (idx + 1);
        }

        @Override
        public int compareTo(Info o) {
            if (this.val == o.val) {
                return this.idx - o.idx;
            }
            return this.val - o.val;
        }
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        arr = new Info[101];
        for (int i = 0; i <= 1000; i++) {
            arr[i] = new Info(i);
        }
        Arrays.sort(arr);

        int len = nums.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int idx = lowerBound(nums.get(i));
            if (idx > 1000 || arr[idx].val != nums.get(i)) {
                answer[i] = -1;
                continue;
            }

            answer[i] = arr[idx].idx;
        }

        return answer;
    }

    static int lowerBound(int target) {
        int lo = 0, hi = 1000, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid].val < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
