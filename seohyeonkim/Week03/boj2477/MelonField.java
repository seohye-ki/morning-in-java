package boj2477;

import java.util.Scanner;

public class MelonField {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//자라는 참외개수
		int N = sc.nextInt();
		int[][] map = new int[6][2];
		int[] cnt = new int[4];
		int[] length = new int[4];
		//밭 정보 입력
		for(int i = 0; i < 6; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			cnt[(map[i][0] - 1)]++;
			length[(map[i][0] - 1)] += map[i][1];
		}
		
		//큰 사각형 구하기
		int result = 0;
		//ㄱ
		if(cnt[0] == 2 && cnt[3] == 2) {
			result = length[1] * length[2];
			for(int i = 0; i < 6; i++) {
				if(i == 5)
					result -= (map[0][1] * map[5][1]);
				else if(map[i][0] == 4 && map[i + 1][0] == 1) {
					result -= (map[i][1] * map[i + 1][1]);
					break;
				}
			}
		}
		//r
		else if(cnt[0] == 2 && cnt[2] == 2) {
			result = length[1] * length[3];
			for(int i = 0; i < 6; i++) {
				if(i == 5)
					result -= (map[0][1] * map[5][1]);
				else if(map[i][0] == 1 && map[i + 1][0] == 3) {
					result -= (map[i][1] * map[i + 1][1]);
					break;
				}
			}
		}
		//ㄴ
		else if(cnt[1] == 2 && cnt[3] == 2) {
			result = length[0] * length[2];
			for(int i = 0; i < 6; i++) {
				if(i == 5)
					result -= (map[0][1] * map[5][1]);
				else if(map[i][0] == 2 && map[i + 1][0] == 4) {
					result -= (map[i][1] * map[i + 1][1]);
					break;
				}
			}
		}
		//J
		else{
			result = length[0] * length[3];
			for(int i = 0; i < 6; i++) {
				if(i == 5)
					result -= (map[0][1] * map[5][1]);
				else if(map[i][0] == 3 && map[i + 1][0] == 2) {
					result -= (map[i][1] * map[i + 1][1]);
					break;
				}
			}
		}
		System.out.println(result * N);
		sc.close();
	}
}
