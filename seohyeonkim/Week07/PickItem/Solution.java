import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};
    static int[][] map; //둘레 표시
    static int[][] visited; //방문처리
    static int[][] distance; //최단거리 계산
    
    //모든 좌표 * 2, 결과값은 / 2
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[100][100];
        visited = new int[100][100];
        distance = new int[100][100];
        
        //둘레 입력하기
        for(int idx = 0; idx < rectangle.length; idx++){
            int x1 = (rectangle[idx][0] - 1) * 2;
            int y1 = (rectangle[idx][1] - 1) * 2;
            int x2 = (rectangle[idx][2] - 1) * 2;
            int y2 = (rectangle[idx][3] - 1) * 2;
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    if(map[i][j] == 2)
                        continue;
                    if(i == x1 || i == x2 || j == y1 || j == y2)
                        map[i][j] = 1;
                    else
                        map[i][j] = 2;
                }
            }
        }
        
        //최단경로 
        Queue<int[]> queue = new LinkedList<>();
        visited[(characterX - 1) * 2][(characterY - 1) * 2] = 1;
        // distance[characterX - 1][characterY - 1] = 1;
        queue.add(new int[] {(characterX - 1) * 2, (characterY - 1) * 2});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0] == (itemX - 1) * 2 && curr[1] == (itemY - 1) * 2)
                break;
            for(int k = 0; k < 4; k++){
                int row = curr[0] + dr[k];
                int col = curr[1] + dc[k];
                if(0 <= row && row < 100 && 0 <= col && col < 100 && visited[row][col] == 0 && map[row][col] == 1){
                    visited[row][col] = 1; //방문처리
                    distance[row][col] = distance[curr[0]][curr[1]] + 1; //distance값 구하기
                    queue.add(new int[] {row, col}); //queue에 추가
                }
            }
        }
        
        return distance[(itemX - 1) * 2][(itemY - 1) * 2] / 2;
    }
}