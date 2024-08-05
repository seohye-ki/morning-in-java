package boj2567;

import java.util.Scanner;

public class Confetti2_v3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] field = new int[100][100];
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int r = y; r < y + 10; r++) {
				for(int c = x; c < x + 10; c++) {
					field[r][c] = 1;
				}
			}
		}
		int cnt = 0;
		for(int r = 0; r < 100; r++) {
			for(int c = 0; c < 100; c++) {
				if(field[r][c] == 1) {
					//좌
					if(c - 1 < 0 || (0 <= c - 1 && field[r][c - 1] == 0))
						cnt++;
					//우
					if(100 <= c + 1 || (c + 1 < 100 && field[r][c + 1] == 0))
						cnt++;
					//상
					if(r - 1 < 0 || (0 <= r - 1 && field[r - 1][c] == 0))
						cnt++;
					//하
					if(100 <= r + 1 || (r + 1 < 100 && field[r + 1][c] == 0))
						cnt++;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
