class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int len = arr.length;
        String now, next;

        if(arr.length == 1) {
            return arr[0].charAt(0) == arr[0].charAt(arr[0].length() - 1);
        }

        if(arr[0].charAt(0) != arr[len - 1].charAt(arr[len - 1].length() - 1)) {
            return false;
        }

        for(int i = 0; i < len - 1; i++) {
            now = arr[i];
            next = arr[i + 1];
            if(now.charAt(now.length() - 1) != next.charAt(0)) {
                return false;
            }
        }

        return true;
    }
}
