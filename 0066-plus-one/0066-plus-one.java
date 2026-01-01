import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        BigInteger num = BigInteger.ZERO;
        int len = digits.length;

        for (int i = 0; i < len; i++) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(digits[i]));
        }

        num = num.add(BigInteger.ONE);

        String s = num.toString();
        len = s.length();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = s.charAt(i) - '0';
        }

        return answer;
    }
}
