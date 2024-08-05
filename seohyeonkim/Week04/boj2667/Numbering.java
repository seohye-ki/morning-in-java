package boj2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Numbering {
	static int N;
	static int[][] map;
	static int[][] visited;
	static int cnt;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1}; //상하좌우
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N]; //지도
		visited = new int[N][N]; //dfs에서 사용
		ArrayList<Integer> complex = new ArrayList<Integer>(); //단지 저장
		
		//input
		for(int i = 0; i < N; i++) {
			String tmp = sc.next();
			for(int j = 0; j < N; j++) {
				if(tmp.charAt(j) == '0')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}
		
		//dfs
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0 && map[i][j] == 1) {
					cnt = 0;
					dfs(i, j);
					complex.add(cnt);
				}
			}
		}
		Collections.sort(complex);

		//output
		System.out.println(complex.size());
		for(int i = 0; i < complex.size(); i++)
			System.out.println(complex.get(i));
		sc.close();
	}
	
	static void dfs(int i, int j) {
		visited[i][j] = 1;
		cnt++;
		
		for(int k = 0;  k < 4; k++) {
			int r = i + dr[k];
			int c = j + dc[k];
			
			if(0 <= r && r < N && 0 <= c && c < N && visited[r][c] == 0 && map[r][c] == 1)
				dfs(r, c);
		}
	}
}
