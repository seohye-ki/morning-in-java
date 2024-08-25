//주의 이거 케이스는 다 통과하는데 효율성테스트 작살남
//아 이런 접근도 있구나 정도로 참고
import java.util.*;

public class Solution_dfs {
    public int solution(int[][] maps) {
        int sero = maps.length;          //세로
        int garo = maps[0].length;       //가로

        int[] dx = {-1, 1, 0, 0};     // 위 아래 왼 오
        int[] dy = {0, 0, -1, 1};

        // 방문 배열을 초기화하고, 시작점을 스택에 추가
        boolean[][] visited = new boolean[sero][garo];
        visited[0][0] = true;
        int[][] distance = new int[sero][garo]; // 최단 거리 배열
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE); // 거리 초기화
        }
        distance[0][0] = 1; // 시작점의 거리

        dfs(maps, 0, 0, visited, dx, dy, sero, garo, distance);

        int answer = distance[sero - 1][garo - 1]; // 도착 지점의 값 (최단 거리)

        // 도착지점에 도달할 수 없는 경우
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // DFS 메서드: 현재 위치 (x, y)에서 시작하여 최단 경로를 찾는다.
    private void dfs(int[][] maps, int x, int y, boolean[][] visited, int[] dx, int[] dy, int sero, int garo, int[][] distance) {
        // 네 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 맵의 범위 내에 있고 이동할 수 있는 칸이며 방문하지 않은 경우
            if (nx >= 0 && nx < sero && ny >= 0 && ny < garo && maps[nx][ny] == 1) {
                // 현재 위치에서 새로운 위치까지의 거리를 계산
                int zipline = distance[x][y] + 1;//집라인 탈 사람? 저요!

                // 최단 거리 조건
                if (zipline < distance[nx][ny]) {
                    distance[nx][ny] = zipline; // 거리 갱신
                    visited[nx][ny] = true; // 방문 처리
                    dfs(maps, nx, ny, visited, dx, dy, sero, garo, distance); // 재귀 호출
                    visited[nx][ny] = false; // 백트래킹을 위한 방문 취소
                }
            }
        }
    }
}