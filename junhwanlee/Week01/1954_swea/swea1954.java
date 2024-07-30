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
            int N = sc.nextInt();
            int[][] nMap = new int[N][N];
            int r = 0;
            int c = 0;
            int n = N-1;
            int num = 1;
            A :
            while (true){
                if (r == n) {
                nMap[r][n] = num;
                    break;
                }
            for (int i = r; i < n; i++) {
                nMap[r][i] =num;
                num++;
                if (num == (N*N)+1) break A;
            }
            for (int j = c; j < n; j++) {
                nMap[j][n] = num;
                num++;
                if (num == (N*N)+1) break A;
            }
            for (int s = n; s > c; s--) {
                nMap[n][s] = num;
                num++;
                if (num == (N*N)+1) break A;
            }
             c++;
            for (int t = n; t >r ; t--) {
                nMap[t][r] = num;
                num++;
                if (num == (N*N)+1) break A;
            }
            r++;
            n--;
            }
            System.out.println("#"+test_case);
            for (int i = 0; i < N ; i++){ 
                for (int t : nMap[i]){
                    System.out.print(t+" ");
                }
                System.out.print("\n");
            }
        }
    }
}