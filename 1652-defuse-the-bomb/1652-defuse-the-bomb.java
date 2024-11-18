class Solution {
    static int len;
    static int[] code;

    public int[] decrypt(int[] code, int k) {
        this.code = code;
        len = code.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            answer[i] = getSum(i, k);
        }

        return answer;
    }

    static int getSum(int index, int k) {
        int sum = 0;
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[(index + i) % len];
            }
        } else if (k < 0) {
            for (int i = 1; i <= -k; i++) {
                sum += code[(index - i + len) % len];
            }
        }
        return sum;
    }
}
