import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
        sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 변수 설정 및 입력======================================
            String oneLine;
            String[][] letters = new String[5][];
            
            
            for (int i=0; i<5; i++) {
                oneLine = sc.nextLine(); // 한 줄 단위로 문자열 받기
                letters[i] = oneLine.split(""); // 문자열 쪼개서 배열로 저장
            }
            // 출력=============================================
            System.out.print("#" + test_case + " ");
            for (int j=0; j<15; j++) {
                for (int i=0; i<5; i++) {
                    try {
                        System.out.print(letters[i][j]);
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            System.out.println();
		}
	}
}