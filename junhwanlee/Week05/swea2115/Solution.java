import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
 
class Solution
{
    static Scanner sc = new Scanner(System.in);
    static int[][] yam;
    static int N, M, C;
    public static void main(String args[]) throws Exception
    {
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            yam = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    yam[i][j] = sc.nextInt();
                }
            }
            int findMax = first();
            System.out.println("#"+test_case+" "+findMax);
        }
    }
 
    public static int first() {
        int findMax = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-M+1; j++) {
                List<Integer> nums = new LinkedList<>();
                int rIdx = i;
                int cIdx = j;
                int sum = 0;
                for (int s = 0; s < M; s++) {
                    nums.add(yam[i][j+s]);
                    sum += yam[i][j+s];
                }
                int maxSum = max(nums, sum);
                int MAX = maxSum + second(rIdx, cIdx, maxSum);
                if (MAX > findMax) {
                    findMax = MAX;
                }
            }
        }
        return findMax;
    }
     
    public static int second(int rIdx, int cIdx, int maxSum) {
        int findMax = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-M+1; j++) {
                if (i != rIdx || (j <= cIdx -M || j >= cIdx + M)) {
                    List<Integer> nums = new LinkedList<>();
                    int sum = 0;
                    for (int s = 0; s < M; s++) {
                        nums.add(yam[i][j+s]);
                        sum += yam[i][j+s];
                    }
                    int MAX = max(nums, sum);
                    if (MAX > findMax) {
                        findMax = MAX;
                    }
                }
            }
        }
        return findMax;
    }
     
    public static int max(List<Integer> nums, int sum) {
        if (sum <= C) {
            int SUM = 0;
            for (int i = 0; i < nums.size(); i++) {
                SUM += nums.get(i)*nums.get(i);
            }
            return SUM;
        }
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            int tmp = nums.get(i);
            int newSum = sum - tmp;
            nums.remove(i);
            int Find = max(nums, newSum);
            if (max < Find) max = Find;
            nums.add(i, tmp);
        }
        return max;
    }
}