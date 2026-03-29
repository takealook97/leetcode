class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        if ((a[0] == b[0] && a[2] == b[2]) ||
            (a[0] == b[2] && a[2] == b[0])) {
            if ((a[1] == b[1] && a[3] == b[3]) ||
                (a[1] == b[3] && a[3] == b[1])) {
                return true;
            }
        }
        return false;
    }
}
