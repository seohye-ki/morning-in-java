package boj1244.switchesonoff;
import java.util.Scanner;

public class boj1244 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //스위치 갯수
		
		int[] switches = new int[T];
		for(int i = 0; i < T; i++)
			switches[i] = sc.nextInt();
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int loc = sc.nextInt();
			//남자 : 받은 수의 배수는 전부다 상태 바꾸기
			if (gender == 1) {
				for(int idx = loc - 1; idx < T; idx++) {
					//배수라면 바꾸기
					if((idx + 1) % loc == 0) {
						if(switches[idx] == 0)
							switches[idx] = 1;
						else
							switches[idx] = 0;
					}
				}
			}
			//여자 : 받은 수를 중심으로 최대로 대칭인 곳 전부 바꾸기
			else {
				int curr = loc - 1;
				if (curr != 0 || curr != T - 1) {					
					int j = 1;
					while(true) {
						//인덱스 넘는지 확인 넘으면 종료 
						if(curr - j < 0 ||  T - 1 < curr + j) {
							j--;
							break;
						}
						//같은지 비교
						if(switches[curr - j] == switches[curr + j])
							j++;
						else {
							j--;							
							break;
						}
					}	
					for(int idx = curr - j; idx <= curr + j; idx++) {
						if(switches[idx] == 0)
							switches[idx] = 1;
						else
							switches[idx] = 0;
					}
				}
				else {
					if(switches[curr] == 0)
						switches[curr] = 1;
					else
						switches[curr] = 0;
				}
			}
		}
		int i = 0;
		while(i < T) {
			System.out.print(switches[i] + " ");
			i++;
			if (i % 20 == 0)
				System.out.println();
		}
		sc.close();
	}
}
