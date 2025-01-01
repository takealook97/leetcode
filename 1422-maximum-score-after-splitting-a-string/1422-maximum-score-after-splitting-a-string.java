class Solution {
    static final char ZERO = '0', ONE = '1';
    
    public int maxScore(String s) {
        int len = s.length();
        int[] zeroCount = new int[len];
        int[] oneCount = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                zeroCount[i] = zeroCount[i - 1];
                oneCount[len - i - 1] = oneCount[len - i];
            }

            if (s.charAt(i) == ZERO) {
                zeroCount[i]++;
            }
            if (s.charAt(len - i - 1) == ONE) {
                oneCount[len - i - 1]++;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < len - 1; i++) {
            answer = Math.max(answer, zeroCount[i] + oneCount[i + 1]);
        }

        return answer;
    }
}
