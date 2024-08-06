public class Solution {

	public int[] solution(int N) {
		
		// 변수
		int[][] snail = new int[N][];
		int[] dr = {1, 0, -1}; // 행 델타 배열
		int[] dc = {0, 1, -1}; // 열 델타 배열
		int idx = 0; // 델타 배열 인덱스
		int row = 0; // 행 인덱스
		int col = 0; // 열 인덱스
		
		// 최대수 구하기
		int max = 0;
		for (int i=1; i<=N; i++) {
			max += i;
		}
		
		// 삼각형 모양 배열로 만들기
		for (int i=0; i<N; i++) {
			snail[i] = new int[i+1];
		}
		
		// 달팽이 숫자 저장
		for (int num=1; num<=max; num++) {
			snail[row][col] = num;
			row += dr[idx];
			col += dc[idx];
			
			if (row<0 || row>=N || col<0 || col>row || snail[row][col]!=0) {
				row -= dr[idx];
				col -= dc[idx];
				idx = ++idx % 3;
				row += dr[idx];
				col += dc[idx];
			}
		}
		
		// 1차원 배열로 저장
		int[] oneD = new int[max];
		int index = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<=i; j++) {
				oneD[index++] = snail[i][j];
			}
		}
		
		// 리턴
		return oneD;
	}

}
