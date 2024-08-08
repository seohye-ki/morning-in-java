package pgs_삼각달팽이;

import java.util.Scanner;

class Solution {
    
    // 방향을 나타내는 배열
    public static int[] dg = {1, 0, -1};  // 행 방향 (아래, 오른쪽, 위)
    public static int[] ds = {0, 1, -1};  // 열 방향 (오른쪽, 아래, 왼쪽)
    
    public int[] solution(int n) {
        // n x n 크기의 격자 생성
        int[][] grid = new int[n][n];
        int r = 0, c = 0, vec = 0;
        
        // 1부터 n*(n+1)/2까지의 숫자를 격자에 채우기
        for (int i = 1; i <= n * (n + 1) / 2; i++) {
            grid[r][c] = i;
            // 방향 변경 조건 확인
            if (r + dg[vec] >= n || c + ds[vec] >= n || r + dg[vec] < 0 || c + ds[vec] < 0 || grid[r + dg[vec]][c + ds[vec]] != 0) {
                vec = (vec + 1) % 3;
            }
            r += dg[vec];
            c += ds[vec];
        }
        
        // 격자의 0이 아닌 숫자들을 1차원 배열로 변환
        int[] answer = new int[n * (n + 1) / 2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    answer[count] = grid[i][j];
                    count++;
                }
            }
        }
        
        return answer;
    }
}

