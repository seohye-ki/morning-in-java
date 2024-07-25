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
            int K =sc.nextInt();
            int ans = 0;
            sc.nextLine();
            String[][] WM = new String[N][N];
            String[][] wm = new String[N][N];
            for (int i = 0; i < N; i++) {
                WM[i] = sc.nextLine().split(" ");
                wm[i] = WM[i].clone();
            }
            int[] r = {1, 0};
            int[] c = {0, 1};
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++){
                    if (WM[i][j].equals("1")){
                        int W = 1;
                        WM[i][j] = "0";
                        int RR = r[1] + i;
                        int CC = c[1] + j;
                            while(RR <N && CC <N && WM[RR][CC].equals("1")){
                                WM[RR][CC] = "0";
                                RR += r[1];
                                CC += c[1];
                                W++;
                            }
                        if (W == K) ans += 1;
                    }
                    if (wm[i][j].equals("1")){
                        int w = 1;
                        wm[i][j] = "0";
                        int rr = r[0] + i;
                        int cc = c[0] + j;
                            while(rr <N && cc <N && wm[rr][cc].equals("1")){
                                wm[rr][cc] = "0";
                                rr += r[0];
                                cc += c[0];
                                w++;
                            }
                        if (w == K ) ans += 1;
                        }
                     
                     
                    }
                }
             System.out.println("#"+test_case+" "+ans);
            }
     
    }
}