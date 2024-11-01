class Solution {
    public String makeFancyString(String s) {
        Set<Integer> set = new HashSet<>();
        int len = s.length(), count = 1;
        char prev = s.charAt(0), cur;
        for(int i = 1; i < len; i++) {
            cur = s.charAt(i);
            if (prev == cur) {
                count++;
                if(count >= 3) {
                    set.add(i);
                }
            } else {
                prev = cur;
                count = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if(!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
