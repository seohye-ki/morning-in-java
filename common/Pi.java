import java.util.Scanner;

class Solution {
	
	static int N;
	static int[][] cheese;
	static boolean[][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// N, 치즈 입력
			N = sc.nextInt();
			cheese = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}
			
			// 최대 덩어리 개수 변수
			int maxChunk = 0;
			
			// 모든 날짜 순회
			for (int day=0; day<=100; day++) {
				
				// 방문 배열 초기화
				visit = new boolean[N][N];
				
				// 덩어리 개수 변수
				int chunk = 0;
				
				// 모든 칸 순회
				for (int row=0; row<N; row++) {
					for (int col=0; col<N; col++) {
						// 방문하거나 요정이 먹은 칸(day보다 작거나 같은 치즈 맛)은 넘김
						if (visit[row][col] || cheese[row][col]<=day)
							continue;
						// 아직 방문하지 않은 칸에 대해 메소드 호출
						fairy(day, row, col);
						// 덩어리 +1
						chunk++;
					}
				}
				// 덩어리 최댓값 갱신
				if (maxChunk < chunk)
					maxChunk = chunk;
			}
			// 결과 출력
			System.out.println("#" + tc + " " + maxChunk);			
		}
	}
	// 치즈 덩어리 메소드
	static void fairy(int day, int row, int col) {
		// 해당 칸 방문 처리
		visit[row][col] = true;
		
		// 델타배열 상하좌우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		// 4방향 탐색
		for (int d=0; d<4; d++) {
			// 인덱스 벗어난다면 넘김
			if (row+dr[d]<0 || row+dr[d]>=N || col+dc[d]<0 || col+dc[d]>=N)
				continue;
			// 방문했다면 넘김
			if (visit[row+dr[d]][col+dc[d]])
				continue;
			// 요정이 먹은 칸도 넘김
			if (cheese[row+dr[d]][col+dc[d]] <= day)
				continue;
			// 이외는 재귀 호출
			fairy(day, row+dr[d], col+dc[d]);
		}
	}
}