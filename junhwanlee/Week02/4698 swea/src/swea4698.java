import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		// 1000001 크기의 boolean 배열 생성
        boolean[] nums = new boolean[1000001];
        
        // 0, 1일 경우 소수가 아니라고 처리 (이 예외 때문에 test case 통과 못 함)
        nums[0] = true;
        nums[1] = true;
        
        // 1000*1000 = 1000000 이므로 1000000의 경우 1000까지의 수로 소수임을 검사하면 소수인지 판별 가능 
        // -> 2부터 1000000 수는 2 ~1000까지의 수들로 소수인지 판별 가능 (1000000보다 작은 수들이기 때문)
        // 따라서 소수인 경우를 제외한 경우는 모두 true로 변경 
    	for (int i = 2; i <= 1000 ; i++) {
            if (nums[i]) continue;
            for (int j = 2; j <= 1000000/i; j++) {
            nums[i*j] = true;
            }
        }
  
    	
    	
    	// T 크기 만큼 반복하여 진행
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// D, A, B 입력 받기
			int D = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int sum = 0;
            
            // 입력 받은 A와 B 범위 안에서
            for (int i = A; i <= B; i++) {
            	int j = i%10;
                int num = i/10;
                
                // 1의 자리수가 D와 동일할 때
                if (j == D) {
                	// nums[i] 가 false 일 때 (소수) sum++ 
                	if (!(nums[i])) {
                        sum++;
                        continue;
                    }
                }
                // 10의 자리, 100의 자리... 가 D와 동일 할 때도 동일하게 진행
                while (num != 0) {
                    j = num % 10;
                    if (j == D) {
                		if (!(nums[i])) {
                        	sum++;
                        	break;
                    	}
                	}
                   num /= 10; 
                }
            }
            // 결과 출력
            System.out.println("#"+test_case+" "+sum);
		}
    }
}