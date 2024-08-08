package boj_1743_음식물;

import java.util.Scanner;

public class Main {
	
	// static 변수
	static boolean[][] floor; // 음식물 쓰레기 위치 이차원 배열
	static boolean[][] visit; // 탐색했는지 표시하는 배열
	static int[] dr = {0, 1, 0, -1}; // 행 방향 델타 배열
	static int[] dc = {1, 0, -1, 0}; // 열 방향 델타 배열
	static int idx = 0; // 델타 배열 인덱스
	static int size = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 값 받기
		int N = sc.nextInt();
		int M = sc.nextInt();
		floor = new boolean[N][M];
		visit = new boolean[N][M];
		int K = sc.nextInt();
		for (int i=0; i<K; i++) {
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;
			floor[row][col] = true;
		}
		
		// DFS 탐색
		int max = 0;
		for (int row=0; row<N; row++) {
			for (int col=0; col<M; col++) {
				// 음식물이 있고 방문하지 않았을 때
				if(floor[row][col] && !visit[row][col]) {
					size = 0;
					dfs(row, col, N, M);
					if (max < size) 
						max = size;
				}
			}
		}
		// 출력
		System.out.println(max);
	}
	
	// DFS 메소드
	static void dfs(int row, int col, int N, int M) {
		visit[row][col] = true;
		size++;
		
		for (int i=0; i<4; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];
			
			if (newRow>=0 && newRow<N && newCol>=0 && newCol<M && floor[newRow][newCol] && !visit[newRow][newCol]) {
				dfs(newRow, newCol, N, M);
			}
		}
	}
}
