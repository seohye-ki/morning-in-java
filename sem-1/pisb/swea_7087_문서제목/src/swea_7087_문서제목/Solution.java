package swea_7087_문서제목;

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
			// 입력 및 변수설정=======================================
            int[] alphabets = new int[26];
            int N = sc.nextInt();
            int firstLetter;
            String word;
            int numberOfTitle = 0;
            
            // 첫글자 알파벳 등장 횟수 저장===================================
            for (int i=0; i<N; i++) {
                word = sc.next();
                firstLetter = (int) word.charAt(0);
                alphabets[firstLetter-65]++; // char형 'A' = 65
            }
            // 최대 제목 개수 계산===========================================
            for (int i=0; i<26; i++) {
                if (alphabets[i]>0) {
                    numberOfTitle++;
                }else if (alphabets[i]==0)
                    break;
            }
            // 출력=================================================
            System.out.println("#"+test_case+" "+numberOfTitle);
		}
	}
}