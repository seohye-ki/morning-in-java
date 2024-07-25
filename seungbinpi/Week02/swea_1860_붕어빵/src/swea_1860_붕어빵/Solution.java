package swea_1860_붕어빵;

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
			// 변수 선언 및 입력=============================================
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int[] numCustomer = new int[11112]; // 도착시간 저장용 배열
            int visitTime; // 도착시간 임시변수
            int bread = 0; // 붕어빵 개수
            String result = "Possible";
            
            // 손님 도착시간 저장============================================
            for (int i=0; i<N; i++) {
                visitTime = sc.nextInt();
                numCustomer[visitTime]++;
            }
            // 계산=====================================================
            for (int i=0; i<11112; i++) {
                // 붕어빵 만들기 M초마다 K개
                if (i%M==0 && i!=0) {
                    bread += K;
                }
                // 손님 방문 시 차감
                bread -= numCustomer[i];
                // 불가능하다면 결과 저장
                if (bread < 0) {
                    result = "Impossible";
                    break;
                }
            }
            // 출력======================================================
            System.out.println("#"+test_case+" "+result);
		}
	}
}