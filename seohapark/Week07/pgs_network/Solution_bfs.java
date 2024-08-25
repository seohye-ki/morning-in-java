import java.util.*;

class Solution_bfs {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 재탕은 좋은 문명

        for (int com = 0; com < n; com++) {
             if (!visited[com]) { 
                bfs(n, computers, com, visited);
                 answer++; 
            }
        }

        return answer;
    }

    // BFS(약간 억지로 끼워맞춘 느낌이 강함... dfs랑 차이 비교용으로만 ㄱㄱ)
    private void bfs(int n, int[][] computers, int com, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>(); // 큐 생성
        queue.offer(com);
        visited[com] = true; // 재탕

        while (!queue.isEmpty()) { // 큐가 불타 없어질때까지
            int current = queue.poll(); // 큐에서 노드를 꺼냄

            for (int i = 0; i < n; i++) { // 모든 노드를 탐색
                if (i != current && computers[current][i] == 1 && !visited[i]) {//재탕
                    queue.offer(i); // 연결된 컴퓨터를 큐에 추가
                    visited[i] = true; // 방문 처리
                }
            }
        }
    }
}