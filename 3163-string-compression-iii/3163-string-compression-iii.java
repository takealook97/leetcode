class Solution {
    public String compressedString(String word) {
        int N = word.length();
        if(N == 1) {
            return word;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        int lo = 0, hi = 1;
        char left, right = ' ';
        while (lo < hi && hi < N) {
            left = word.charAt(lo);
            right = word.charAt(hi);
            if (left == right) {
                if(count >= 9) {
                    sb.append(count).append(right);
                    hi++;
                    lo = hi - 1;
                    count = 1;
                } else {
                    count++;
                    hi++;
                }
            } else {
                sb.append(count).append(left);
                lo = hi;
                hi++;
                count = 1;
            }
        }
        sb.append(count).append(right);

        return sb.toString().trim();
    }
}
