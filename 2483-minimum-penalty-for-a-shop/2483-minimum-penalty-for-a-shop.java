class Solution {
    public int bestClosingTime(String customers) {
        int len = customers.length();
        int[] yArr = new int[len + 2];
        int[] nArr = new int[len + 2];
        yArr[1] = customers.charAt(0) == 'Y' ? 1 : 0;
        nArr[1] = customers.charAt(0) == 'N' ? 1 : 0;
        for (int i = 2; i < len + 1; i++) {
            char c = customers.charAt(i - 1);
            if (c == 'Y') {
                yArr[i] = yArr[i - 1] + 1;
                nArr[i] = nArr[i - 1];
            } else {
                yArr[i] = yArr[i - 1];
                nArr[i] = nArr[i - 1] + 1;
            }
        }
        yArr[len + 1] = yArr[len];
        nArr[len + 1] = nArr[len];

        int penalty = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < len + 2; i++) {
            int p = 0;
            p += yArr[len + 1] - yArr[i];
            p += nArr[i];
            if (penalty > p) {
                penalty = p;
                answer = i;     
            }

            if (penalty == 0) {
                return i;
            }
        }

        return answer;
    }
}