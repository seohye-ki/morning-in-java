import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	// static 변수
	static int[][] map;
	static int N;
	static int M;
	
    public int solution(int[][] maps) {
//	public static void main(String[] args) {
//		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		// 배열 전역변수로
		map = maps;
		
		// 배열 행, 열 길이
		N = maps.length;
		M = maps[0].length;
		
		int answer = bfs();
        
//		System.out.println(answer);
        return answer;
    }
	static int bfs() {
		
		// 큐 만들어서 첫번째 칸 인덱스 큐에 넣음
		Queue<int[]> queue = new LinkedList<>();
		int arr[] = {0, 0, 1};
		queue.add(arr);
		
		// 방문한 곳 표시하는 배열
		boolean[][] visit = new boolean[N][M];
		
		// 첫번째 칸 방문 표시
		visit[0][0] = true;
		
		// 거리 저장 변수
		
		// 델타 배열
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			
			// 큐의 마지막 원소가 기준
			int row = queue.peek()[0];
			int col = queue.peek()[1];
			int distance = queue.peek()[2];
			
			// 4방향으로 갈 수 있는지 체크
			for (int delta=0; delta<4; delta++) {
				// 인덱스 변경
				int newRow = row + dr[delta];
				int newCol = col + dc[delta];
				// 인덱스가 벗어나지 않고, 방문하지 않았고, 갈 수 있는 칸이면
				if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M &&
						!visit[newRow][newCol] &&
						map[newRow][newCol] == 1) {
					// 방문 표시
					visit[newRow][newCol] = true;
					// 해당 인덱스 큐에 넣기
					int[] temp = {newRow, newCol, distance+1};
					queue.add(temp);
					
					// 도착점에 도착했다면 이동거리 추가 후 종료
					if (newRow==N-1 && newCol==M-1) 
						return distance+1;
				}
			}
			// 마지막 원소 큐에서 빼기
			queue.poll();
		}
		
		// 도착점에 도착하지 못하고 반복문 종료 시 -1 리턴
		return -1;
	}
}



