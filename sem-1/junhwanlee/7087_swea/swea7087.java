import java.util.Scanner;
import java.util.Arrays;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        String[] en = {"A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            String[] word = new String[N];
            for (int i = 0 ; i < N ; i++) {
                word[i] = sc.next();
            }
            Arrays.sort(word);
            String[][] WORD = new String[N][30];
            for (int i = 0 ; i < N ; i++) {
                WORD[i] = word[i].split("");
            }
            int idx = 0;
            for (int i = 0; i < N; i++) {
                if (WORD[i][0].equals(en[idx])) {
                    idx++;
                }
                if (idx == en.length) break;
            }
            System.out.println("#"+test_case+" "+idx);
        }
    }
}