package swea_1979;

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
            // N, K 입력=========================================
            int N = sc.nextInt();
            int K = sc.nextInt();
            // 테두리 한칸 씩 더 있는 퍼즐 모양 입력=======================
            // 테두리는 검은색(0)
            int[][] puzzleBoard = new int[N+2][N+2];
            for (int i=1; i<N+1; i++) {
                for (int j=1; j<N+1; j++) {
                    puzzleBoard[i][j] = sc.nextInt();
                }
            }
            int cnt = 0; // 자리수 카운트 변수
            int tmpInt;
            // 가로 검사=========================================
            for (int i=1; i<N+1; i++) {
                for (int j=1; j<=N-K+1; j++) {
                	if (puzzleBoard[i][j-1]==0 && puzzleBoard[i][j+K]==0) { // 양 끝이 막혀있고(검은색이거나 테두리)
                        tmpInt = 1;
                        for (int k=0; k<K; k++) {
                            tmpInt *= puzzleBoard[i][j+k]; // 그 사이가 모두 흰색일 때
                        }
                        if (tmpInt==1)
                            cnt++; // 카운트 +1
                    }
                }
            }
            // 세로 검사=========================================
            for (int j=1; j<N+1; j++) {
                for (int i=1; i<=N-K+1; i++) {
                	if (puzzleBoard[i-1][j]==0 && puzzleBoard[i+K][j]==0) {
                        tmpInt = 1;
                        for (int k=0; k<K; k++) {
                            tmpInt *= puzzleBoard[i+k][j];
                        }
                        if (tmpInt==1)
                            cnt++;
                    }
                }
            }
            // 출력========================================
            System.out.println("#"+test_case+" "+cnt);
		}
	}
}