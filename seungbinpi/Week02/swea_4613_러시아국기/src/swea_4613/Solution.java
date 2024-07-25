package swea_4613;

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
			// 입력==============================================
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] oldFlag = new int[N][M];
            String tmp;
            for (int i=0; i<N; i++) {
                tmp = sc.next();
                for (int j=0; j<M; j++) {
                    if (tmp.substring(j, j+1).equals("W"))
                        oldFlag[i][j] = 1;
                    else if (tmp.substring(j, j+1).equals("B"))
                        oldFlag[i][j] = 2;
                    else
                        oldFlag[i][j] = 3;
                }
            }
            //검사============================================
            int change = 0;
            int minChange = N*M;
            //1~N-1 중 2개의 조합
            for (int row1=1; row1<N; row1++) {
                for (int row2=1; row2<N; row2++) {
                    if (row1>=row2)
                        continue;
                    // 색칠 칸 세기
                    change = 0;
                    for (int i=0; i<N; i++) {
                        for (int j=0; j<M; j++) {
                            // 흰색을 칠하는 행
                            if (i<row1) {
                                if (oldFlag[i][j]!=1)
                                    change += 1;
                            }
                            // 파란색을 칠하는 행
                            else if (i<row2) {
                                if (oldFlag[i][j]!=2)
                                    change += 1;
                            }
                            // 빨간색을 칠하는 행
                            else {
                                if (oldFlag[i][j]!=3)
                                    change += 1;
                            }
                        }
                    }
                    // 최솟값 갱신
                    if (minChange > change)
                        minChange = change;
                }
            }
            // 출력================================================
            System.out.println("#"+test_case+" "+minChange);
		}
	}
}