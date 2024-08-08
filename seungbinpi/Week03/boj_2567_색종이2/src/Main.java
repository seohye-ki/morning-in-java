import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 설정 및 입력=======================================
		int[][] board = new int[101][101];
		int cnt = 0;
		int N = sc.nextInt();
		
		// 색종이 붙이기===========================================
		for (int paper=0; paper<N; paper++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i=x; i<x+10; i++) {
				for (int j=y; j<y+10; j++) {
					if (i<100 && j<100) {
						board[i][j] = 1;
					}
				}
			}
		}
		// 세로 둘레 길이 계산========================================
		for (int x=0; x<101; x++) {
			int prev = 0;
			for (int y=0; y<101; y++) {
				if (board[x][y] != prev) {
					prev = 1 - prev;
					cnt++;
				}
			}
		}
		// 가로 둘레 길이 계산=======================================
		for (int y=0; y<101; y++) {
			int prev = 0;
			for (int x=0; x<101; x++) {
				if (board[x][y] != prev) {
					prev = 1 - prev;
					cnt++;
				}
			}
		}
		
		// 출력======================================================
		System.out.println(cnt);
	}

}
