package swea_1215;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=2;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            //입력=========================================================
            int N = sc.nextInt();
            String[][] alphabets = new String[8][8];
            String temp;
            for (int i=0; i<8; i++) {
                temp = sc.next();
                for (int j=0; j<8; j++) {
                    alphabets[i][j] = temp.substring(j, j+1);
                }
            }
            //가로 검사
            int count = 0;
            for (int i=0; i<=8-N; i++) {
                for (int j=0; j<=8-N; j++) {
                    exit_for:
                    for (int k=0; k<=N/2; k++) {
                        if (!(alphabets[i][j+k].equals(alphabets[i][j+N-1-k]))) {
                            break exit_for;
                        }
                        if (k==N/2) {
                            count += 1;
                        }
                    }
                }
            }
            //세로 검사======================================================
            for (int j=0; j<=8-N; j++) {
                for (int i=0; i<=8-N; i++) {
                    exit_for:
                    for (int k=0; k<=N/2; k++) {
                        if (!(alphabets[i+k][j].equals(alphabets[i+N-1-k][j]))) {
                            break exit_for;
                        }
                        if (k==N/2) {
                            count += 1;
                        }
                    }
                }
            }
            //출력===========================================================
            System.out.println("#"+test_case+" "+count);
		}
	}
}
