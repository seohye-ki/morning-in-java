package boj_1592_영식이;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력 및 변수 생성============================================
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] friends = new int[N];
		int ball = 0;
		int cnt = 0;
		
		// 계산======================================================
		while (true) {
			// 공 받은 사람이 공 받은 횟수 홀수일 때
			if (friends[ball]%2==1) {
				friends[ball]++; // 공 받은 횟수 증가
				if (friends[ball]==M) // M번째이면 중단
					break;
				ball += L; // 시계방향으로 L만큼 옆으로
				cnt++; // 공 던지기 횟수 증가
				if (ball>=N) // 인덱스 조정
					ball -= N;
			}
			// 공 받은 사람이 공 받은 횟수 홀수일 때
			else {
				friends[ball]++;
				if (friends[ball]>=M)
					break;
				ball -= L;
				cnt++;
				if (ball<0)
					ball += N;
			}
		}
		// 출력=====================================================
		System.out.println(cnt);
	}
}