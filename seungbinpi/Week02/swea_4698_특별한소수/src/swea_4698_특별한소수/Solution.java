package swea_4698_특별한소수;

import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.Math;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력 및 변수설정========================================
            int D = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int specialPrime = 0; // 특별한 소수 개수
            boolean testPrime;
                        
            // 계산================================================
            for (int i=A; i<=B; i++) {
                // 소수인지 검사
                testPrime = true;
                for (int j=2; j<i; j++) {
                    if (i%j == 0) {
                        testPrime = false;
                        break;
                    }
                }
                // 특별한 소수인지 검사
                if (testPrime) { // 소수인 경우만 검사
                	for (int n=1; n<=7; n++) {
                    	if (i - (i/(int) Math.pow(10,n))*(int) Math.pow(10,n) == D) {
                        	specialPrime++;
                        	break;
                    	}
                	}
                }
            }
            // 출력================================================
            System.out.println("#"+test_case+" "+specialPrime);
		}
	}
}