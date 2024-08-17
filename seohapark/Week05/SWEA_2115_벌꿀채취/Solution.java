package SWEA_2115_벌꿀채취;

import java.util.Scanner;

public class Solution {
    static int N, M, C; 
    static int[][] ggul; // 각 셀의 꿀 양을 저장하는 2차원 배열
    static int result; // 최종 최대 수익을 저장할 변수
    static int profit; // 현재 선택된 꿀의 최대 수익을 저장할 변수
    static int[] temp; // 선택된 꿀 양을 임시로 저장할 배열

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

            result = 0; 
            profit = 0; 
            choose(0, 0, 0, 0); // 꿀 채취 호출

            // 현재 테스트 케이스의 결과 출력
            System.out.println("#" + t + " " + result);
        } 
        }// 테스트 케이스 반복 종료
    } // 메인 메서드 종료

    // 꿀을 선택하는 메서드
    static void choose(int cnt, int sum, int startx, int starty) {
        // 만약 두 개의 셀 그룹을 선택했을 경우
        if (cnt == 2) {
            if (result < sum) result = sum; // 현재 합이 최대 수익보다 크면 너가 최대값
            return; //아니면 빠꾸
        }

        // 그리디 사용
        for (int i = startx; i < N; i++) {
            int tmp = 0;
            if(startx == i) // 시작 행과 현재 행이 같으면 시작 열 지정
                tmp = starty;
            
            // 선택할 셀의 범위 내에서 반복
            for (int j = tmp; j <= N - M; j++) {
                int s = 0; // 현재 선택된 꿀의 합
                int profit = 0; // 현재 선택된 꿀의 수익
                temp = new int[M]; // 선택된 꿀을 임시로 저장할 배열 초기화

                // 연속된 M개의 셀에서 꿀을 선택
                for (int k = 0; k < M; k++) {
                    s += ggul[i][j + k]; // 선택된 꿀의 총합
                    profit += ggul[i][j + k] * ggul[i][j + k]; // 꿀 수익 계산
                    temp[k] = ggul[i][j + k]; // 선택된 꿀을 임시 배열에 저장
                }

                // 만약 꿀의 총합이 최대 용량 이하라면
                if (s <= C) {
                    choose(cnt + 1, sum + profit, i, j + M); // 다음 셀 그룹 선택
                } else { // 최대 용량을 초과하면
                    choose(cnt + 1, sum + count(), i, j + M); // 수익 계산 후 다음 셀 그룹 선택
                }
            }
        }
    }

    // 최대 수익을 계산하는 메서드
    static int count() {
        profit = 0; // 수익 초기화
        subs(0, 0, 0); // 부분 집합을 통한 최대 수익 계산 시작
        return profit; // 최대 수익 반환
    }

    // 부분 집합을 통한 최대 수익 계산
    static void subs(int cnt, int sum, int m) {
        // 꿀의 합이 최대 용량을 초과하면 리턴
        if (sum > C) return;

        // 모든 셀을 다 선택했을 경우
        if (cnt == M) {
            if (profit < m) profit = m; // 현재 수익이 최대 수익보다 크면 갱신
            return;
        }

        // 현재 셀을 포함하는 경우
        subs(cnt + 1, sum + temp[cnt], m + temp[cnt] * temp[cnt]);
        // 현재 셀을 포함하지 않는 경우
        subs(cnt + 1, sum, m);
    }
} // 클래스 종료
