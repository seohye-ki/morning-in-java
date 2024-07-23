
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		// T 만큼 반복 진행
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// N, M 입력 받기
			int N = sc.nextInt();
            int M = sc.nextInt();
            
            // N, M 크기의 배열 생성 후 입력 받기
            String[][] R_N = new String[N][M];
            for (int i = 0; i < N; i++) {
                R_N[i] = sc.next().split("");
            }
            
            // min, ans 설정 (어떠한 값이 나와도 변하도록 엄청 크게 설정)
            // s 설정 ( s번째 줄에서 색깔 변경) 
            int min = 100000;
            int s = 1;
            int ans = 1000000;
            
            // s의 값을 변화시키면서 값 얻기 위한 while문 설정 (맨 마지막 전 줄에서는 색이 1번은 변하여야 하니 N-1까지) 
           while (s < N-1) {
        	   
        	   // t 설정 (s 이후 t번째 줄에서 추가적인 색깔 변셩)
            	int t = s+1;
            	
            	// t의 값을 변화시키면서 값 얻기 위해 while문 설정 (s보다는 크게, N번째까지 가능)
                while (t < N) {
                	
                	// 함수에 대입
                    ans = find(R_N, s, t, N, M);
                    if ( ans < min) min = ans;
                	t++;
                }
               s++;
            }
            System.out.println("#"+test_case+" "+min);
		}
	}
	
	// 각 경우별로 바꿔줘야 할 색깔의 수 계산 함수
    public static int find (String[][] R_N, int s, int t, int N, int M)
        {
            int cor = 0;
            
            // 주어진 s 값까지 "W"가 아닌 값들의 수 세서 더하기
            for (int i = 0;i < s; i++){
                for (int j = 0; j < M; j++) {
            	if (R_N[i][j].equals("B") || R_N[i][j].equals("R")) {
                	cor++;
                }
                }
            }
            
            // 주어진 s ~ t-1 값까지 "B"가 아닌 값들의 수 세서 더하기
            for (int i = s;i < t; i++){
                for (int j = 0; j < M; j++) {
                if (R_N[i][j].equals("R") || R_N[i][j].equals("W")) {
                	cor++;
                }
               }
            }
            
            // 주어진 t ~ N 값까지 "R"가 아닌 값들의 수 세서 더하기
            for (int i = t;i < N; i++){
                for (int j = 0; j < M; j++) {
                if (R_N[i][j].equals("B") || R_N[i][j].equals("W")) {
                	cor++;
               }
                }
            }
            
            // 바꿔야 할 색깔의 총 개수 return
            return cor;
        }
}