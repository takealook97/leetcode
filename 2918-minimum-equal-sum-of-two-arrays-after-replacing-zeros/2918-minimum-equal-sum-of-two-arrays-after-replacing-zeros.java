class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zeroCntA = 0, zeroCntB = 0;
        long sumA = 0L, sumB = 0L;

        for (int num : nums1) {
            if (num == 0) {
                zeroCntA++;
            } else {
                sumA += num;
            }
        }
        for (int num : nums2) {
            if (num == 0) {
                zeroCntB++;
            } else {
                sumB += num;
            }
        }

        long minA = sumA + zeroCntA;
        long minB = sumB + zeroCntB;

        if (minA == minB) return minA;
        if (minA > minB) return zeroCntB == 0 ? -1 : minA;
        return zeroCntA == 0 ? -1 : minB;
    }
}
