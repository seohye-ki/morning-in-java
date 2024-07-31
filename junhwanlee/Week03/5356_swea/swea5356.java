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
            System.out.print("#"+test_case+" ");
            String[][] word = new String[5][];
            for (int i = 0; i < 5; i++) {
                word[i] = sc.next().split("");
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    try {
                        System.out.print(word[j][i]);
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            System.out.print("\n");
        }
    }
}