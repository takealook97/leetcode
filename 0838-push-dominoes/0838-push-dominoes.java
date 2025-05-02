class Solution {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        char[] arr = dominoes.toCharArray();
        int[] forces = new int[len];

        int force = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'R') {
                force = len;
            } else if (arr[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        force = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                force = len;
            } else if (arr[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            if (f > 0) {
                sb.append('R');
            } else if (f < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }
}
