import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dC = {0, 0, 1, -1};
    int[] dR = {1, -1, 0, 0};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] run = new boolean[n][m];
        int[][] bfs = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int c = 0;
        int r = 0;
        int[] addN = {0, 0}; 
        queue.add(addN);
        run[c][r] = true;
        bfs[c][r] = 1;
        while (!queue.isEmpty()) {
            c = queue.peek()[0];
            r = queue.poll()[1];
            for (int i = 0; i < 4; i++) {
                int y = c - dC[i];
                int x = r - dR[i];
                if (y < 0 || y > n-1 || x < 0 || x > m-1 ) {
                    continue;
                }
                if (!run[y][x] && maps[y][x] != 0) {
                    run[y][x] = true;
                    
                    if (bfs[y][x] == 0 ) {
                        bfs[y][x] = bfs[c][r]+1;
                        queue.add(new int[] {y, x});
                    }
                }
            }
            if (bfs[n-1][m-1] != 0) {
                break;
            }
        }      
        if (bfs[n-1][m-1] == 0) {
            bfs[n-1][m-1] = -1;
        }
        int answer = bfs[n-1][m-1];
        return answer;
    }
}