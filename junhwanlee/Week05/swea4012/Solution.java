import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
 
class Solution
{
    static Scanner sc = new Scanner(System.in);
    static int[][] yam;
    static int N;
    static List<Integer> list;
    public static void main(String args[]) throws Exception
    {
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            yam = new int[N][N];
            list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    yam[i][j] = sc.nextInt();
                }
                list.add(i);
            }
            int idx = 0;
            boolean[] used = new boolean[N];
            List<Integer> cur = new LinkedList<>(); 
            int ans = choice(cur, used, idx);
            System.out.println("#"+test_case+" "+ans);
        }
    }
     
    public static int choice(List<Integer> cur, boolean[] used, int idx) {
        if ((idx == N && cur.size() != N/2)) return Integer.MAX_VALUE;
        int minDif = Integer.MAX_VALUE;
        if (cur.size() == N/2) {
            List<Integer> madeFood = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if(!used[i]) {
                    madeFood.add(i);
                }
            }
            int dif = Math.abs(make(cur) - make(madeFood));
            minDif = Math.min(dif, minDif);
            if (minDif == 0) return minDif;
        }
        else {
            if(!used[idx]) {
                int dif1 = choice(cur, used, idx+1);
                minDif = Math.min(dif1, minDif);
                cur.add(idx);
                used[idx] = true;
                int dif2 = choice(cur, used, idx+1);
                minDif = Math.min(dif2, minDif);
                used[idx] = false;
                cur.remove(cur.size()-1);
            }
        }
        return minDif;
 
    }
     
    public static int make(List<Integer> madeFood) {
        int sum = 0;
        for (int i = 0; i < N/2; i++) {
            for (int j = i+1; j < N/2; j++) {
                sum += yamyam(madeFood.get(i), madeFood.get(j));
            }
        }
        return sum;
    }
     
    public static int yamyam(int food1, int food2) {
        return yam[food1][food2] + yam[food2][food1];
    } 
}