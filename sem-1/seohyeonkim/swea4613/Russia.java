package swea4613;

import java.util.Arrays;
import java.util.Scanner;

public class Russia {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			//입력 
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flag = new int[N][M];
			for(int i = 0; i < N; i++) {
				String color = sc.next();
				for(int j = 0; j < M; j++) {
					if(color.charAt(j) == 'W')
						flag[i][j] = 0;
					else if(color.charAt(j) == 'B')
						flag[i][j] = 1;
					else
						flag[i][j] = 2;
				}
			}
			
			//칠해야하는 갯수 계산 
			int[][] coloring = new int[N][3];
			for(int i = 0; i < N; i++)
				Arrays.fill(coloring[i], M);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(flag[i][j] == 0)
						coloring[i][0]--;
					else if(flag[i][j] == 1)
						coloring[i][1]--;
					else
						coloring[i][2]--;
				}
			}
			
			//조합
			int min = 2500;
			for(int i = 1; i < N - 1; i++) {
				for(int j = N - 1; j > i; j--) {
					int sum = 0;
					for(int k = 0; k < i; k++)
						sum += coloring[k][0];
					for(int k = i; k < j; k++)
						sum += coloring[k][1];
					for(int k = j; k < N; k++)
						sum += coloring[k][2];
					if(sum < min)
						min = sum;
				}
			}
			
			//출력 
			System.out.println("#" + (t+1) + " " + min);
		}
		sc.close();
	}
}
