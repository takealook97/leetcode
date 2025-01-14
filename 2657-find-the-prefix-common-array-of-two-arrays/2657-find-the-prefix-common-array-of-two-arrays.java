class Solution {
    static final int SIZE = 50;

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] count = new int[SIZE + 1];
        int[] answer = new int[len];
        int cur = 0;
        for (int i = 0; i < len; i++) {
            count[A[i]]++;
            count[B[i]]++;
            if (count[A[i]] >= 2) {
                cur++;
            }
            if (count[B[i]] >= 2 && A[i] != B[i]) {
                cur++;
            }

            answer[i] = cur;
        }

        return answer;
    }
}