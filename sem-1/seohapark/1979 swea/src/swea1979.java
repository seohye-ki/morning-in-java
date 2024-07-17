import java.util.Scanner;
public class swea1979 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
//		배열 입력받기(nmbrng=numbering)
		for (int nmbrng = 1; nmbrng<=T; nmbrng++) {
			int N = input.nextInt();
			int K = input.nextInt();
			int[][] array = new int[N][N];
			int result = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
				array[i][j]=input.nextInt();
			}
//			세로축 계산
			for(int i=0; i<N; i++) {
				int tmps = 0;
//				현재 탐색하는 칸의 연속된 하얀색 수(?)을 임시변수로 설정(s는 세로의 s)
				for(int j=0; j<N; j++) {
					if(array[j][i] == 0) {
						if(tmps == K) {
							result=result + 1;
//							0인 블럭(검정)에 도달했는데 tmp가 K값을 만족한다면 결과에 하나 메모
						}
						tmps=0;
//						메모 완료 후 재탐색
					}else {
						tmps=tmps+1;
//						검은 부분이 아니다 = 그냥 가던길 가라
					}
				}
//				그런데 이것만 진행하면 맨 끝자락이 하얀 부분으로 끝날때 처리를 못함...(한 칸 앞에 검은거 없잖아? 나 오류날게)
//				그때를 위한 예외처리문(끝에 검은거 없어도 tmps값이 K를 만족한다면 결과값에 하나 추가해줘라)
				if(tmps == K) {
					result = result +1;
				}
			}
			
//			이 밑, 가로 있으리(원리는 동일, i, j 위치만 조심)
			for(int i=0; i<N; i++) {
				int tmpg = 0;
				for(int j=0; j<N; j++) {
					if(array[i][j] == 0) {
						if(tmpg ==K) {
							result=result + 1;
						}
						tmpg=0;
					}else {
						tmpg=tmpg+1;
					}
				}
				if(tmpg == K) {
					result = result +1;
				}
			}
//			빰빠까빰
	System.out.printf("#%d %d\n",nmbrng,result);
		}
	}
}
