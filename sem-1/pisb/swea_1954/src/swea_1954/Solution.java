package swea_1954;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // N 입력 및 2차원 배열 생성============================
			int N = sc.nextInt();
            int[][] snail = new int[N][N];
            // 배열에 숫자 할당==================================
            int row = 0;
            int column = -1;
            int number = 1;
            end_while:
            while (number<=N*N) {
                // 첫 줄 오른쪽으로 N개 입력
                for (int i=0; i<N; i++) {
                    column += 1;
                    snail[row][column] = number;
                    number += 1;
                }
                for (int j=N-1; j>0; j-=2) {
                    // 아래쪽으로 j개 입력
                    for (int i=1; i<=j; i++) {
                        row += 1;
                        snail[row][column] =number;
                        number +=1;
                    }
                    // 왼쪽으로 j개 입력
                    for (int i=1; i<=j; i++) {
                        column -= 1;
                        snail[row][column] = number;
                        number += 1;
                        if (number>N*N) // 다 입력했으면 while문 종료
                            break end_while;
                    }
                    // 위쪽으로 j-1개 입력
                    for (int i=1; i<=j-1; i++) {
                        row -= 1;
                        snail[row][column] =number;
                        number +=1;
                    }
                    // 오른쪽으로 j-1개 입력
                    for (int i=1; i<=j-1; i++) {
                        column += 1;
                        snail[row][column] = number;
                        number += 1;
                        if (number>N*N) // 다 입력했으면 while문 종료
                            break end_while;
                    }
                }
            }
            // 출력===============================================
            System.out.println("#"+test_case);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(snail[i][j]+" ");
                }
                System.out.println();
            }
		}
    }
}