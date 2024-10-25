import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> answer = new ArrayList<>();
        
        String prev = null;
        
        for (String cur : folder) {
            if (prev == null || !cur.startsWith(prev + "/")) {
                answer.add(cur);
                prev = cur;
            }
        }
        
        return answer;
    }
}
