class Solution {
    public List<String> stringMatching(String[] words) {
        int len = words.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (words[i].contains(words[j])) {
                    set.add(words[j]);
                }
                if (words[j].contains(words[i])) {
                    set.add(words[i]);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
