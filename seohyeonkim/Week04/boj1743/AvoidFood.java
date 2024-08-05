package boj1743;

import java.util.Scanner;

public class AvoidFood {
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int[][] visit;
	static int[][] map;
	static int N;
	static int M;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //row
		M = sc.nextInt(); //column
		int K = sc.nextInt(); //음식물 수
		map = new int[N][M]; //음식물 위치 맵
		for(int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r - 1][c - 1] = 1;
		}
		
		visit = new int[N][M];
		int max = 0; //가장 큰 음식물의 크기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visit[i][j] == 0 && map[i][j] == 1) {
					cnt = 0; //카운트 초기화
					dfs(i, j);
					if(max < cnt) //max값 비교
						max = cnt;
				}
			}
		}
		System.out.println(max);
		sc.close();
	}
	
	static void dfs(int i, int j) {
		//현재 내 위치
		visit[i][j] = 1;
		cnt++;
		
		//델타탐색
		for(int k = 0; k < 4; k++) {
			int r = i + dr[k];
			int c = j + dc[k];
			
			if(0 <= r && r < N && 0 <= c && c < M && visit[r][c] == 0 && map[r][c] == 1)
				dfs(r, c);
		}
	}
}
