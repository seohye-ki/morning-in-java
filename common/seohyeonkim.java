import java.util.Scanner;

public class seohyeonkim {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N; //한변의 크기
	static int[][] map;
	static boolean[][] visited; //방문처리
	static int max; //가장 많은 조각 수
	static int curr; //현재 조각수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			//input
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			
			//변수 초기화
			max = 1;
			curr = 1;
			
			//현재 조각수가 0보다 클 동안(먹을 치즈가 있음)
			while(curr > 0) {
				eat(); //치즈먹기
				//치즈 조각 세기
				curr = 0;
				visited = new boolean[N][N];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(visited[i][j] == false && map[i][j] != 0) {
							count(i, j);
							curr++;
						}
					}
				}
				
				//최댓값 비교
				if(curr > max)
					max = curr;
			}
			
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
	
	static void count(int i, int j) {
		visited[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int row = i + dr[k];
			int col = j + dc[k];
			if(0 <= row && row < N && 0 <= col && col < N && visited[row][col] == false && map[row][col] != 0)
				count(row, col);
		}
	}
	
	static void eat() {
		//맵을 돌면서 모두 -1하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] > 0)
					map[i][j]--;
			}
		}
	}
}
