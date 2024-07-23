

import java.util.Scanner;
	 
	 
public class swea11315
{
	public static void main(String args[]) throws Exception
	{
	    // Scanner 설정
		Scanner sc = new Scanner(System.in);
	    int T;
	    T=sc.nextInt();
	    // 주어진 test_case 만큼 반복
	    for(int test_case = 1; test_case <= T; test_case++)
	    {
	        // N 입력
	    	int N = sc.nextInt();
	        sc.nextLine();
	        
	        // 2차원 배열 생성 후 o, . 입력
	        String[][] OM = new String[N][N];
	        for (int i = 0 ; i < N; i++) 
	        {
	            OM[i] = sc.nextLine().split("");
	        }
	        // 오른쪽, 왼쪽, 아래, 대각(오른쪽), 대각(왼쪽)
	        int[] r ={0, 0, -1, -1, -1};
	        int[] c = {1, -1, 0,  1, -1};
	        // 기본 답변 "NO" 설정
	        String as = "NO";
	        //반복을 통해 o 탐색 (중간에 오목 찾으면 모두 brak)
	        for (int j = 0; j <N; j++) 
	        {
	            if (as.equals("YES")) break;
	            for (int k = 0; k < N; k++)
	            {
	                if (as.equals("YES")) break;
	                // 현재 위치가 "o"인지 확인
	                if (OM[j][k].equals("o"))
	                {
	                	// 현재 "o"일 경우 주변 아래로 탐색
	                    for (int s = 0; s <5; s++)
	                    {
	                        if (as.equals("YES")) break;
	                        int rr = r[s] + j;
	                        int cc = c[s] + k;
	                        int om = 1;
	                        // "o"인 지점이 5개 나올 때가지 탐색
	                        while (cc >=0 && cc<N && rr >=0 && rr<N && om != 5) 
	                        {
	                            if (OM[rr][cc].equals(".")) break;
	                            rr += r[s];   
	                            cc += c[s];
	                            om += 1;
	                        }
	                        // 오목 탐색 시 "YES" 전환
	                        if (om == 5) as = "YES";
	                    }
	                }
	            }
	        }
	        // 결과값 프린트
	        System.out.println("#"+test_case+" "+as);
	    }
    }
}