package SWEA_4012_요리사;

import java.util.Scanner;

public class Solution {
    static int T, N;
    static int[][] lunatic;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            lunatic = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    lunatic[i][j] = sc.nextInt();
                }
            }

            result = Integer.MAX_VALUE; 
            whichteam(0, 0, new boolean[N]);

            System.out.println("#" + t + " " + result);
        }
    }

    static void whichteam(int index, int count, boolean[] selected) {
        if (count == N / 2) {
            int blueSum = caltaste(selected);
            int redSum = caltaste(switchteam(selected));
            result = Math.min(result, Math.abs(blueSum - redSum));
            return;
        }

        for (int i = index; i < N; i++) {
            selected[i] = true; // adding team
            whichteam(i + 1, count + 1, selected);
            selected[i] = false; // removing team
        }
    }

    static int caltaste(boolean[] selected) {
        int sumoftaste = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    sumoftaste += lunatic[i][j] + lunatic[j][i];
                }
            }
        }
        return sumoftaste;
    }

    static boolean[] switchteam(boolean[] selected) {
        boolean[] opposite = new boolean[N];
        for (int i = 0; i < N; i++) {
            opposite[i] = !selected[i];
        }
        return opposite;
    }
}
