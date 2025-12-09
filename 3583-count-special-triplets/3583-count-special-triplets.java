class Solution {
    static HashMap<Integer, List<Integer>> map;
    static final int MOD = 1000000007;

    public int specialTriplets(int[] nums) {
        int len = nums.length;
        map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        int answer = 0;

        for (int key : map.keySet()) {
            if (key % 2 != 0 || map.get(key / 2) == null) {
                continue;
            }

            List<Integer> list = map.get(key);
            int size = list.size();

            List<Integer> targetList = map.get(key / 2);
            int targetSize = targetList.size();

            if (key == 0) {
                long x = ((long) size * (long) (size - 1) * (long) (size - 2) / 6 % MOD);
                answer += (int) x;
                continue;
            }

            for (int jPos : targetList) {
                int lower = lowerBound(list, jPos);
                int upper = upperBound(list, jPos);
                long left = lower;
                long right = size - upper;
                long add = (left * right) % MOD;
                answer += add;
                answer %= MOD;
            }
        }

        return answer;
    }


    static int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1, mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }


    static int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1, mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
