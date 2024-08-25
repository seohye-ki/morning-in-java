package pgs_network;

import java.util.*;
//문제가 타겟넘버와 거의 똑같으니 주석은 대충 달겠음(딮스 빞스 둘다)
class Solution_dfs {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; //너 익숙한 얼굴이니?
        
        for (int com = 0; com < n; com++) {
             if (!visited[com]) { // 아직 방문하지 않은 컴퓨터가 있다면
                dfs(n, computers, com, visited);
                 answer++; // 넷웍 하나 더
            }
        }
        
        return answer;
    }
    
    // 국룰 메서드
    private void dfs(int n, int[][] computers, int com, boolean[] visited) {
        visited[com] = true; // 콤에 들어간 메서드는 이미 방문한거다? 메모
        
        for (int i = 0; i < n; i++) { //스캔
            if (i != com && computers[com][i] == 1 && !visited[i]) {//커런트가 아닌 방문안한 노드가 있고 연결되지 않은 다른 컴퓨타가 있다면(연결대상이라면)
                dfs(n, computers, i, visited); // 자 다시 갔다와
            }
        }
    }
}
