class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int need = 1 << k;
        if (n < need + k - 1) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>(need * 2);
        int mask = need - 1;

        int v = 0;
        for (int i = 0; i < n; i++) {
            v = ((v << 1) & mask) | (s.charAt(i) - '0');
            if (i >= k - 1) {
                set.add(v);
                if (set.size() == need) {
                    return true;
                }
            }
        }

        return false;
    }
}