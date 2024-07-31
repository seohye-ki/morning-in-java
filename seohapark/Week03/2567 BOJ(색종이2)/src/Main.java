import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new java.util.Scanner(System.in);

        // 도화지 크기와 색종이 크기
        final int SIZE = 100;
        final int PAPER_SIZE = 10;
        
        // 도화지 배열 초기화 (0: 흰색, 1: 검은색)
        int[][] canvas = new int[SIZE][SIZE];
        
        // 색종이 개수 입력
        int n = input.nextInt();
        
        // 색종이 배치
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            
            // 색종이의 각 셀을 검은색으로 설정
            for (int row = y; row < y + PAPER_SIZE; row++) {
                for (int col = x; col < x + PAPER_SIZE; col++) {
                    canvas[row][col] = 1;
                }
            }
        }

        // 결과값
        int result = 0;
        
        // 각 셀을 검사하여 상하좌우 봐서 색이 자기와 다를 경우 둘레 계산
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (canvas[row][col] == 1) {
                    // 상
                    if (row == 0 || canvas[row - 1][col] == 0) {
                        result++;
                    }
                    // 하
                    if (row == SIZE - 1 || canvas[row + 1][col] == 0) {
                        result++;
                    }
                    // 좌
                    if (col == 0 || canvas[row][col - 1] == 0) {
                        result++;
                    }
                    // 우
                    if (col == SIZE - 1 || canvas[row][col + 1] == 0) {
                        result++;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(result);

    }
}

