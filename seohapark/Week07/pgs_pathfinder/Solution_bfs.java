//정석
import java.util.*;

public class Solution_bfs {
    public int solution(int[][] maps) {
        int sero = maps.length;          
        int garo = maps[0].length;       

        int[] dx = {-1, 1, 0, 0};     //위 아래 왼 오
        int[] dy = {0, 0, -1, 1};     

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // ㅇㄷ?
            int x = current[0];
            int y = current[1];

            // 사방탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵의 범위 내에 있고 이동할 수 있는 칸인 경우
                if (nx >= 0 && nx < sero && ny >= 0 && ny < garo && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1; // 이동 가능하고 방문하지 않은 경우에 거리 갱신
                    queue.offer(new int[]{nx, ny}); // 새로운 위치를 추가
                }
            }
        }

        int answer = maps[sero - 1][garo - 1]; // 도착 지점의 값 (최단 거리)

        // if 못찾겠다 > 그냥 버려
        if (answer == 1) {
            return -1;
        } else {
            return answer;
        }
    }
}