package triangle_snail;

class TriangleSnail {
    static int[] dr = {1, 0, -1}; //하-우-상
    static int[] dc = {0, 1, -1}; //하-우-상
    static int idx = 0;
    
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        //최대숫자 고르기
        int total = 0;
        for(int i = 1; i <= n; i++){
            total += i;
        }
        
        //달팽이 채우기
        int r = 0;
        int c = 0;
        int num = 1;
        while(num <= total){
            snail[r][c] = num;
            if(r + dr[idx] < 0 || n <= r + dr[idx] || r < c + dc[idx] || snail[r + dr[idx]][c + dc[idx]] != 0){
                idx++;
                if(idx == 3)
                    idx = 0;
            }
            r += dr[idx];
            c += dc[idx];
            num++;
        }
        int[] answer = new int[total];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(snail[i][j] != 0){
                    answer[k] = snail[i][j];
                    k++;                    
                }
            }
        }
        return answer;
    }
}