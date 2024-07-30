package boj_10158_개미;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 및 변수설정=========================================
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		
		int tx = t%(w*2); // x좌표 실질 이동 시간
		int ty = t%(h*2); // y좌표 실질 이동 시간
				
		// 계산==================================================
		// x좌표
		p += tx;
		if (p>w*2)
			p -= w*2;
		else if (p>w)
			p = 2*w - p; 
		
		// y좌표
		q += ty;
		if (q>h*2)
			q -= h*2;
		else if (q>h)
			q = 2*h - q; 
		// 출력==================================================
		System.out.println(p + " " + q);
	}
}
