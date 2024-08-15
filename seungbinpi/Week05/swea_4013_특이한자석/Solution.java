import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[][] wheel = new int[4][8];
	static boolean[] between = new boolean[3];
	static int[] rotation = new int[4];
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			int K = sc.nextInt();
			for (int i=0; i<4; i++) {
				for (int j=0; j<8; j++) {
					wheel[i][j] = sc.nextInt();
				}
			}
			
			// K번 반복
			for (int iter=1; iter<=K; iter++) {
				int number = sc.nextInt() - 1; // 1이면 0번 자석
				int direction = sc.nextInt(); // 1시계, 2반시계
				
				// 맞붙은 곳이 인력이 작용하는 곳 구하기
				between = new boolean[3];
				attract();
				
				// 톱니 바퀴 회전 방향 정해주기
				rotation = new int[4];
				visit = new boolean[4];
				ableRotation(number, direction);
				
				// rotation 배열 값에 따라 회전시키기
				for (int numWheel=0; numWheel<4; numWheel++) {
					rotate(numWheel, rotation[numWheel]);
				}
			}
			
			// 점수 계산
			int score = 0;
			if (wheel[0][0] == 1)
				score += 1;
			if (wheel[1][0] == 1)
				score += 2;
			if (wheel[2][0] == 1)
				score += 4;
			if (wheel[3][0] == 1)
				score += 8;
			
			// 출력
			System.out.println("#" + test_case + " " + score);
		}
	}
	
	static void attract() {
		// 0번 자석과 1번 자석 사이
		if (wheel[0][2] != wheel[1][6])
			between[0] = true;
		// 1번 자석과 2번 자석 사이
		if (wheel[1][2] != wheel[2][6])
			between[1] = true;
		// 2번 자석과 3번 자석 사이
		if (wheel[2][2] != wheel[3][6])
			between[2] = true;
	}
	
	static void ableRotation(int number, int direction) {
		// 기저 조건
		if (number<0 || number>3)
			return;
		
		// 회전 방향 결정
		rotation[number] = direction;
		visit[number] = true;
		
		// 재귀
		if (number>0 && between[number-1] && !visit[number-1]) {
			ableRotation(number-1, direction*(-1));
		}
		if (number<3 && between[number] && !visit[number+1]) {
			ableRotation(number+1, direction*(-1));
		}
	}
	
	static void rotate(int numWheel, int dir) {
		// 시계 방향일 때
		if (dir == 1) {
			int temp = wheel[numWheel][7];
			for (int i=7; i>=1; i--) {
				wheel[numWheel][i] = wheel[numWheel][i-1];
			}
			wheel[numWheel][0] = temp;
		}
		// 반시계 방향일 때
		else if (dir == -1) {
			int temp = wheel[numWheel][0];
			for (int i=0; i<=6; i++) {
				wheel[numWheel][i] = wheel[numWheel][i+1];
			}
			wheel[numWheel][7] = temp;
		}
	}
}

// 설계: 23:02 ~ 23:22
// 코딩: 23:22 ~ 24:04

// 크기 3의 boolean 배열: between
// between[0] = true: 0번자석 2번날 != 1번자석 6번 날
// between[1] = true: 1번자석 2번날 != 2번자석 6번 날
// between[2] = true: 2번자석 2번날 != 3번자석 6번 날

// 크기 4의 int 배열: rotation
// n번 자석 rotation 1 or -1로 변경
// between[n] = true 이면 n+1 자석 rotation -1 or 1로 변경
// between[n-1] = true 이면 n-1 자석 rotation -1 or 1로 변경

// rotation 배열 값에 따라 회전시키고
// rotation 배열은 초기화

// 시계방향 회전 메소드
// 반시계방향 회전 메소드