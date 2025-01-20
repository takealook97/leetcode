class Solution {
    static final int Y = 0, X = 1;

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;
        int max = N * M;

        int[][] pos = new int[max + 1][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                pos[mat[i][j]][Y] = i;
                pos[mat[i][j]][X] = j;
            }
        }

        int[] yCnt = new int[N];
        int[] xCnt = new int[M];

        Arrays.fill(yCnt, M);
        Arrays.fill(xCnt, N);

        int answer = 0;
        for (int num : arr) {
            int y = pos[num][Y];
            int x = pos[num][X];
            yCnt[y]--;
            xCnt[x]--;

            if (yCnt[y] == 0 || xCnt[x] == 0) {
                break;
            }

            answer++;
        }
        
        return answer;

    }
}
