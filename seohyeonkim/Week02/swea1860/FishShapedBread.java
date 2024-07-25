package swea1860;

import java.util.Scanner;

public class FishShapedBread {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt(); //예약자
			int M = sc.nextInt(); //만드는데 걸리는 시간
			int K = sc.nextInt(); //한번에 만들 수 있는 붕어빵의 갯수
			
			//입력받으면서 제일 늦게오는 손님 찾기(만약 0초에 손님오면 바로 불가능)
			int[] custumer = new int[N];
			int maxTime = 0;
			int flag = 0;
			for(int i = 0; i < N; i++) {
				custumer[i] = sc.nextInt();
				if(maxTime < custumer[i])
					maxTime = custumer[i];
				if(custumer[i] == 0)
					flag = 1;
			}
			
			//계산(붕어빵 만들어지는 시간마다 cnt += K, 손님오면 cnt--
			//만약에 마지막손님이 오거나 
			int cnt = 0;
			int time = 1;
			while(flag == 0) {
				//붕어빵 만들어지는 시간
				if(time % M == 0)
					cnt += K;
				//time에 오는 손님 수 계산 후 붕어빵 개수 차감
				int num = 0;
				for(int i = 0; i < N; i++) {
					if(custumer[i] == time)
						num++;
				}
				cnt -= num;
				//종료조건 확인
				if(cnt < 0 || maxTime < time) {
					if(cnt < 0)
						flag = 1;
					break;
				}
				time++;
			}
			if(flag == 1)
				System.out.println("#" + (t+1) + " " + "Impossible");
			else
				System.out.println("#" + (t+1) + " " + "Possible");
		}
		sc.close();
	}
}