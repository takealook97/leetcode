class Solution {
    static int len;
    static char[] arr, target;

    public boolean rotateString(String s, String goal) {
        len = s.length();
        arr = s.toCharArray();
        target = goal.toCharArray();

        if(len != goal.length()) {
            return false;
        }

        if(s.equals(goal)) {
            return true;
        }

        for (int i = 0; i < len; i++) {
            shift();
            if(isEqual()) {
                return true;
            }
        }
        
        return false;
    }

    static void shift() {
        char temp = arr[len - 1];
        for (int i = len - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    static boolean isEqual() {
        for (int i = 0; i < len; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }

        return true;
    }
}
