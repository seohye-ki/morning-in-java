package SWEA_2115_벌꿀채취;

import java.util.Scanner;

public class Solution {
    static int N, M, C;
    static int[][] ggul;
    static int result;
    static int profit;
    static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            ggul = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ggul[i][j] = sc.nextInt();
                }
            }
            result = 0;
            profit = 0;
            choose(0, 0, 0, 0); // gotochoose
            System.out.println("#" + t + " " + result);
        } // edoftcfor
    } // edofmain

    static void choose(int cnt, int sum, int startx, int starty) {
        if (cnt == 2) {
            if (result < sum) result = sum;
            return; // no other case available if cnt is two
        }

        for (int i = startx; i < N; i++) {
        	int tmp = 0;
        	if(startx==i)
        		tmp = starty;
            for (int j = tmp; j <= N - M; j++) {
                int s = 0; 
                int profit = 0; 
                temp = new int[M];

                for (int k = 0; k < M; k++) {
                    s += ggul[i][j + k]; 
                    profit += ggul[i][j + k] * ggul[i][j + k]; 
                    temp[k] = ggul[i][j + k]; 
                }

                if (s <= C) {
                    choose(cnt + 1, sum + profit, i, j + M);
                } else {
                    choose(cnt + 1, sum + count(), i, j + M);
                }
            }
        }
    }

    static int count() {
        profit = 0; 
        subs(0, 0, 0); 
        return profit; 
    }

    static void subs(int cnt, int sum, int m) {
        if (sum > C) return;

        if (cnt == M) {
            if (profit < m) profit = m;
            return;
        }

        subs(cnt + 1, sum + temp[cnt], m + temp[cnt] * temp[cnt]);
        subs(cnt + 1, sum, m);
    }
} // edofsol
