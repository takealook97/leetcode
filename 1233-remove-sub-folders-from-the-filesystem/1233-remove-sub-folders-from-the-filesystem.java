class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        int len = folder.length, base = 0, idx = 0;
        List<String> answer = new ArrayList<>();
        answer.add(folder[0]);
        while (idx < len) {
            int iLen = folder[idx].length(), bLen = folder[base].length();
            if (folder[idx].startsWith(folder[base])) {
                if (iLen == bLen ||
                    (iLen > bLen && folder[idx].charAt(folder[base].length()) == '/')) {
                } else {
                    answer.add(folder[idx]);
                    base = idx;
                }
            } else {
                answer.add(folder[idx]);
                base = idx;
            }
            
            idx++;
        }

        return answer;
    }
}
