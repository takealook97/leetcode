class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int count = 0;
        int lo = 0;
        int hi = 0;

        while (hi < len + k - 1) {
            if (hi > 0 && colors[hi % len] == colors[(hi - 1) % len]) {
                lo = hi;
            }

            hi++;

            if (hi - lo < k) continue;

            count++;
            lo++;
        }

        return count;
    }
}
