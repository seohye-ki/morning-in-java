package swea4698;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		//에라토스테네스의 체
		boolean[] isPrime = new boolean[1000000 + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i = 2; i * i <= 1000000; i++) {
			if(isPrime[i] == true) {
				for(int j  = i * i; j <= 1000000; j += i)
					isPrime[j] = false;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int D = sc.nextInt(); //포함해야할 숫자
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int total = 0;
			for(int num = A; num <= B; num++) {			
				//특별한 숫자 들어가는지 판별
				if(isPrime[num] == false)
					continue;
				String str = Integer.toString(num);
				for(int i = 0; i < str.length(); i++) {
					if(str.charAt(i) == D + '0') {
						total++;
						break;
					}
				}
			}
			System.out.println("#" + (t+1) + " " + total);
		}
		sc.close();
	}
}
