class Solution {
    static boolean[] visited; //방문처리
    static int net_cnt = 0; //네트워크 갯수
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i] == false && computers[i][j] == 1){
                    dfs(i, j, n, computers);
                    net_cnt++;                    
                }
            }
        }
        return net_cnt;
    }
    
    static void dfs(int row, int col, int N, int[][] computers){
        visited[row] = true;
        
        for(int i = 0; i < N; i++){
            if(computers[row][i] == 1 && visited[i] == false)
                dfs(i, 0, N, computers);
        }
    }
}