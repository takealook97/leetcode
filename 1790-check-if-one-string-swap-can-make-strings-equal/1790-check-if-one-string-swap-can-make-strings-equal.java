class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int len = s1.length();
        ArrayList<Character> listA = new ArrayList<>();
        ArrayList<Character> listB = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if (a != b) {
                listA.add(a);
                listB.add(b);
            }
        }

        if (listA.size() != 2) {
            return false;
        }

        return listA.get(0) == listB.get(1) && listA.get(1) == listB.get(0);
    }
}
