import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // 입력==============================================
            int N = sc.nextInt();
            String tmp;
            int[][] letterBoard = new int[8][8];
            for (int i=0; i<8; i++) {
                // 한줄(8글자) 입력
                tmp = sc.next();
                for (int j=0; j<8; j++) {
                    // 한글자씩 쪼개고, A=1, B=2, C=3으로 저장
                    if (tmp.substring(j,j+1).equals("A")) {
                        letterBoard[i][j] = 1;
                    } else if (tmp.substring(j,j+1).equals("B")) {
                        letterBoard[i][j] = 2;
                    } else {
                        letterBoard[i][j] = 3;
                    }
                }
            }
            // 회문 검사======================================
            int cnt = 0;
            int horizontal;
            int vertical;
            // 가로
            for (int i=0; i<8; i++) {
                for (int j=0; j<=8-N; j++) {
                    horizontal = 0;
                    for (int k=0; k<N/2; k++) {
                        if (letterBoard[i][j+k] == letterBoard[i][j-k+N-1]) {
                            horizontal += 1;
                            if (horizontal == N/2)
                                cnt += 1;
                        }
                    }
                }
            }
            // 세로
            for (int j=0; j<8; j++) {
                for (int i=0; i<=8-N; i++) {
                    vertical = 0;
                    for (int k=0; k<N/2; k++) {
                        if (letterBoard[i+k][j] == letterBoard[i-k+N-1][j]) {
                            vertical += 1;
                            if (vertical == N/2)
                                cnt += 1;
                        }
                    }
                }
            }
            // 출력============================================
            System.out.println("#"+test_case+" "+cnt);
		}
	}
}