package boj_28278_스택2;


// 출력도 버퍼로 바꿔야...


import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] arg) throws NumberFormatException, IOException {
		// 변수 및 자료 구조
		String[] strCommand = new String[2];
		int command;
		int x;
		Stack<Integer> stackInt = new Stack<>();
		
		// 버퍼리더 설정
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// N 입력
		int N = Integer.parseInt(bf.readLine());
		
		// 명령 입력
		for (int i=0 ; i<N; i++) {
			strCommand = bf.readLine().split(" ");
			command = Integer.parseInt(strCommand[0]);
			switch(command) {
			case 1: x = Integer.parseInt(strCommand[1]);
					stackInt = Main.method1(stackInt, x);
					break;
			case 2: stackInt = Main.method2(stackInt);	
					break;		
			case 3: Main.method3(stackInt);	
					break;		
			case 4: Main.method4(stackInt);	
					break;		
			case 5: Main.method5(stackInt);	
					break;
			}			
		}
	}
	// 1번 명령
	public static Stack<Integer> method1(Stack<Integer> stackInt, int x) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		stackInt.push(x);
		return stackInt;
	}
	// 2번 명령
	public static Stack<Integer> method2(Stack<Integer> stackInt) {
		if (stackInt.empty())
			System.out.println(-1);
		else
			System.out.println(stackInt.pop());
		return stackInt;
	}
	// 3번 명령
	public static void method3(Stack<Integer> stackInt) {
		System.out.println(stackInt.size());
	}
	// 4번 명령
	public static void method4(Stack<Integer> stackInt) {
		if (stackInt.empty())
			System.out.println(1);
		else
			System.out.println(0);
	}
	// 5번 명령
	public static void method5(Stack<Integer> stackInt) {
		if (stackInt.empty())
			System.out.println(-1);
		else
			System.out.println(stackInt.peek());
	}
}