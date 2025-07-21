class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int lo = 0, hi = 0;
        char l, h;
        while (hi < len) {
            l = s.charAt(lo);
            h = s.charAt(hi);
            if (h == l) {
                if (hi - lo < 2) {
                    sb.append(h);
                }
            } else {
                sb.append(h);
                lo = hi;
            }

            hi++;
        }

        return sb.toString();
    }
}
