class Solution {
	
	static String[] place;
	static boolean[][] visit;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
    public static int[] solution(String[][] places) {
        
        // 정답 담을 배열
        int[] answer = new int[5];
        
        // 5개의 케이스 반복
        for (int test_case=0; test_case<5; test_case++) {
            place = places[test_case];
            
            // dfs 방문 여부 배열
            visit = new boolean[5][5];
            
            // 결과값 담을 변수
            int result = 1;
            
            // 모든 자리에 대해 순회
            // P에 대해서는 dfs 탐색
            quit_for:
            for (int row=0; row<5; row++) {
                for (int col=0; col<5; col++) {
                    String seat = place[row].substring(col, col+1);
                    
                    // 사람이 있고, 방문하지 않았다면 dfs 탐색
                    if (seat.equals("P") && !visit[row][col]) {
                        result = dfs(row, col, 0);
                        // 결과로 0이 나왔으면 break
                        if (result == 0)
                            break quit_for;
                    }
                }
            }
            // 결과 저장
            answer[test_case] = result;
        }
         return answer;
    }
    
    // dfs 메소드
    public static int dfs(int row, int col, int distance) {
    	// visit 저장
    	visit[row][col] = true;
    	// distance가 0보다 크고 P이면 0 리턴
    	if (distance>0 && place[row].substring(col, col+1).equals("P"))
    		return 0;
    	// distance 증가
    	distance++;
    	// 네방향 반복
    	for (int i=0; i<4; i++) {
    		// 인덱스 변경
    		int newRow = row + dr[i];
    		int newCol = col + dc[i];
    		// 거리가 2를 초과하지 않고, 인덱스도 안 벗어나고
            // 방문 안했고, 파티션이 아니면 하나 더 탐색
    		if (distance <= 2 &&
    				newRow >= 0 && newRow<5 && newCol >= 0 && newCol <5 &&
                    !visit[newRow][newCol] &&
    				!place[newRow].substring(newCol, newCol+1).equals("X")) {
    			int result = dfs(newRow, newCol, distance);
    			// 리턴 값이 0이면 0리턴
    			if (result == 0)
    				return 0;
    		}
    	}
    	// 문제 없다면 1 리턴
    	return 1;
    }
}


