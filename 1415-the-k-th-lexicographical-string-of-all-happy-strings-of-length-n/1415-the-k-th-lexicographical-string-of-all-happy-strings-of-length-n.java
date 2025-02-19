class Solution {
    static int n, k;
    static Set<String> set;

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;
        set = new HashSet<>();

        find(new StringBuilder());

        if (set.size() < k) {
            return "";
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(k - 1);
    }

    static void find(StringBuilder sb) {
        if (sb.length() >= n) {
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < 3; i++) {
            char c = (char) ('a' + i);
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                find(sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
