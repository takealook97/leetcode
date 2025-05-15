class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int len = words.length;

        List<String> listA = new ArrayList<>();
        int aStart = 0;
        listA.add(words[0]);

        List<String> listB = new ArrayList<>();
        int bStart = 0;
        for (int i = 1; i < len; i++) {
            if (groups[0] != groups[i]) {
                listB.add(words[i]);
                bStart = i;
                break;
            }
        }

        int aStatus = groups[aStart], bStatus = groups[bStart];
        for (int i = 1; i < len; i++) {
            if (aStatus != groups[i]) {
                aStatus = groups[i];
                listA.add(words[i]);
            }

            if (i > bStart && bStatus != groups[i]) {
                bStatus = groups[i];
                listB.add(words[i]);
            }
        }

        if (listA.size() >= listB.size()) {
            return listA;
        }
        
        return listB;
    }
}
