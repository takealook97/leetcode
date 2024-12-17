class Solution {
    static final int SIZE = 26;

    public String repeatLimitedString(String s, int repeatLimit) {
        int len = s.length();
        int[] arr = new int[SIZE];

        for (int i = 0; i < len; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int cur = -1;
        int remaining = len;

        while (remaining > 0) {
            boolean added = false;

            for (int i = SIZE - 1; i >= 0; i--) {
                if (arr[i] > 0 && cur != i) {
                    int toAppend = Math.min(arr[i], repeatLimit);
                    
                    for (int j = 0; j < toAppend; j++) {
                        sb.append((char) (i + 'a'));
                    }
                    
                    arr[i] -= toAppend;
                    remaining -= toAppend;
                    cur = i;
                    added = true;
                    break;
                }
            }

            if (!added) {
                break;
            }

            if (cur != -1 && arr[cur] > 0) {
                for (int i = SIZE - 1; i >= 0; i--) {
                    if (arr[i] > 0 && i != cur) {
                        sb.append((char) (i + 'a'));
                        arr[i]--;
                        remaining--;
                        cur = -1;
                        break;
                    }
                }
            }
        }

        return sb.toString();
    }
}
