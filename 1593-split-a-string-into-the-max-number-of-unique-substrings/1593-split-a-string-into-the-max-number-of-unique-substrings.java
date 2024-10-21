import java.util.*;

class Solution {
    public int maxUniqueSplit(String s) {

        return find(s, 0, new HashSet<>());
    }

    private int find(String s, int start, HashSet<String> set) {
        if (start == s.length()) {
            return 0;
        }

        int maxCount = 0;

        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);

            if (!set.contains(substring)) {
                set.add(substring);
                int count = 1 + find(s, i, set);
                maxCount = Math.max(maxCount, count);
                set.remove(substring);
            }
        }

        return maxCount;
    }
}
