class Solution {
    public int minimumOneBitOperations(int n) {
        int answer = 0;
        while (n > 0) {
            answer ^= n;
            n >>= 1;
        }
        return answer;
    }
}
