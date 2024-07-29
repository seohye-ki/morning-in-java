package swea5356;

import java.util.Scanner;

public class SayVertical {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			char[][] str = new char[5][15];
			//입력
			for(int i = 0; i < 5; i++) {
				String tmp = sc.next();
				for(int j = 0; j < tmp.length(); j++) {
					str[i][j] = tmp.charAt(j);
				}
				for(int j = tmp.length(); j < 15; j++) {
					str[i][j] = '*';
				}
			}
			
			//출력
			System.out.print("#" + (t+1) + " ");
			for(int j = 0; j < 15; j++) {
				for(int i = 0; i < 5; i++) {
					if(str[i][j] != '*')
						System.out.print(str[i][j]);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
