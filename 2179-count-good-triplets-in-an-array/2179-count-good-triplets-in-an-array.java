class Solution {
    static class BIT {
        long[] tree;
        int size;

        public BIT(int n) {
            size = n + 2;
            tree = new long[size];
        }

        public void update(int i, long delta) {
            i++;
            while (i < size) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        public long query(int i) {
            i++;
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] indexInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            indexInNums2[i] = pos[nums1[i]];
        }

        BIT bit = new BIT(n);
        long[] left = new long[n];
        for (int i = 0; i < n; i++) {
            left[i] = bit.query(indexInNums2[i]);
            bit.update(indexInNums2[i], 1);
        }

        bit = new BIT(n);
        long answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            long right = bit.query(n - 1) - bit.query(indexInNums2[i]);
            answer += left[i] * right;
            bit.update(indexInNums2[i], 1);
        }

        return answer;
    }
}
