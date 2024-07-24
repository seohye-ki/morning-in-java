package boj2527;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			int r1_x = sc.nextInt();
			int r1_y = sc.nextInt();
			int r1_p = sc.nextInt();
			int r1_q = sc.nextInt();
			int r2_x = sc.nextInt();
			int r2_y = sc.nextInt();
			int r2_p = sc.nextInt();
			int r2_q = sc.nextInt();
			
			String result = "";
			//r1이 왼
			if(r1_x <= r2_x) {
				if((r1_p == r2_x && r1_q == r2_y) ||
					(r1_p == r2_x && r1_y == r2_q))
					result = "c";
				else if(r1_p < r2_x || r1_q < r2_y || r1_y > r2_q)
					result = "d";
				else if(r1_p == r2_x || r1_q == r2_y || r1_y == r2_q)
					result = "b";
				else
					result = "a";
			}
			//r2가 왼 
			else {
				if((r2_p == r1_x && r2_q == r1_y) ||
					(r2_p == r1_x && r2_y == r1_q))
					result = "c";
				else if(r2_p < r1_x || r2_q < r1_y || r2_y > r1_q)
					result = "d";
				else if(r2_p == r1_x || r2_q == r1_y || r2_y == r1_q)
					result = "b";
				else
					result = "a";
			}
			System.out.println(result);
		}
		sc.close();
	}
}
