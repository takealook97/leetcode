class Solution {
    public char kthCharacter(int k) {
        int n = 0;
        while (Math.pow(2, n) < k) {
            n++;
        }
        n++;

        StringBuilder sb;
        String s = "a";
        while (n-- > 0) {
            sb = new StringBuilder(s);
            for (char c : s.toCharArray()) {
                sb.append((char) (c + 1));
            }

            s = sb.toString();
        }

        return s.charAt(k - 1);
    }
}