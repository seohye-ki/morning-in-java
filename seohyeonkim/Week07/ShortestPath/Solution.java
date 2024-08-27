import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};
    static int[][] distance; //거리 계산해서 넣을 배열
    static int[][] visited; //방문처리할 배열
    
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>(); //큐
        
        int N = maps.length; //행        
        int M = maps[0].length; //열
        distance = new int [N][M];
        visited = new int[N][M];
        
        //첫번째 요소 넣기
        queue.add(new int[] {0, 0});
        visited[0][0] = 1;
        distance[0][0] = 1;
        
        //BFS
        while(!queue.isEmpty()) {
            int[] target = queue.poll();
            //델타 탐색
            for(int k = 0; k < 4; k++){
                int row = target[0] + dr[k];
                int col = target[1] + dc[k];
                if(0 <= row && row < N && 0 <= col && col < M && visited[row][col] == 0 && maps[row][col] == 1){
                    distance[row][col] = distance[target[0]][target[1]] + 1;
                    visited[row][col] = 1;
                    queue.add(new int[] {row, col});            
                }
            }
        }
        
        //output
        if(distance[N - 1][M - 1] == 0)
            return -1;
        else
            return distance[N - 1][M - 1];
    }
}