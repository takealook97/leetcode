class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = part.length();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= n && sb.substring(sb.length() - n).equals(part)) {
                sb.delete(sb.length() - n, sb.length());
            }
        }
        return sb.toString();
    }
}
