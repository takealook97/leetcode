class Solution {
    public boolean checkOnesSegment(String s) {
        int len = s.length();
        if (len == 1) {
            return s.charAt(0) == '1';
        }

        int count = 0;
        boolean check = false;
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
            if (s.charAt(i) == '1' || s.charAt(i + 1) == '1') {
                check = true;
            }
        }

        if (check && count <= 1) {
            return true;
        }

        return false;
    }
}
