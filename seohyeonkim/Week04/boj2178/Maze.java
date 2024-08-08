package boj2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
	static int[] dr = {0, 1, 0, -1}; //우하좌상
	static int[] dc = {1, 0, -1, 0}; //우하좌상
	static int[][] map;
	static int[][] visited;
	static int[][] dist;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		dist = new int[N][M];
		
		//input
		for(int i = 0; i < N; i++) {
			String tmp = sc.next();
			for(int j = 0; j < M; j++)
				map[i][j] = (int)(tmp.charAt(j) - '0');
		}
		
		//bfs
		bfs();
		System.out.println(dist[N - 1][M - 1]);
		sc.close();
	}
	
	static void bfs() {
		visited[0][0] = 1;
		dist[0][0] = 1;
		Queue<int[]> queue = new LinkedList<>();
		//큐가 빌때까지 해야해서 처음값은 넣어둬야 함
		queue.offer(new int[] {0,0}); //첫번째 값 넣기
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			//4방향 확인하고 1인 곳이 있으면 큐에 넣기
			for(int k = 0; k < 4; k++) {
				int r = curr[0] + dr[k];
				int c = curr[1] + dc[k];
				if(r >= 0 && r < N && c >= 0 && c < M && visited[r][c] == 0 && map[r][c] == 1) {
					visited[r][c] = 1;
					dist[r][c] = dist[curr[0]][curr[1]] + 1;
					queue.offer(new int[] {r, c});
				}
			}
		}
	}
}
