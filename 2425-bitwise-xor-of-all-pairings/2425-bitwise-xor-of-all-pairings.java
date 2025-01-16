class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int a = 0, b = 0;

        for (int num : nums1) {
            a ^= num;
        }

        for (int num : nums2) {
            b ^= num;
        }

        int answer = 0;
        if (nums2.length % 2 == 1) {
            answer ^= a;
        }
        if (nums1.length % 2 == 1) {
            answer ^= b;
        }

        return answer;
    }
}
