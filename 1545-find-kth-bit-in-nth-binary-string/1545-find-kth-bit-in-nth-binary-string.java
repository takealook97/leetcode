import java.util.*;

class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder left = new StringBuilder();
        StringBuilder right;
        left.append(0);

        if (k == 1) {
            return '0';
        }

        int cnt = 1;
        
        String leftStr, rightStr;
        int len;
        while(cnt++ < n) {
            leftStr = left.toString();
            len = leftStr.length();
            right = new StringBuilder();

            if (k <= len) {
                return left.toString().charAt(k - 1);
            }

            // invert
            for (int i = 0; i < len; i++) {
                right.append(leftStr.charAt(i) == '0' ? '1' : '0');
            }

            left.append(1).append(right.reverse().toString());
        }

        return left.toString().charAt(k - 1);
        
    }

}