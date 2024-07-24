package swea7087;

import java.util.Scanner;

public class MakeTitle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int[] alphabet = new int[26];
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				String title = sc.next();
				alphabet[title.charAt(0) - 'A']++;
			}
			
			int cnt = 0;
			for(int i = 0; i < 26; i++) {
				if(alphabet[i] == 0)
					break;
				cnt++;
			}
			System.out.println("#" + (t+1) + " " + cnt);
		}
		sc.close();
	}
}
