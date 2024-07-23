package boj28278;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		String[] stack = new String[T];

		for(int i = 0; i < T; i++) {
			//명령어 입력받기
			String cmd = br.readLine();
			//pop
			if(cmd.equals("2")) {
				if(cnt == 0) {
					bw.write("-1\n");
				}
				else {
					cnt--;
					bw.write(stack[cnt] + "\n");
					stack[cnt] = "0";
				}
			}
			//들어있는 정수 갯수
			else if(cmd.equals("3")) {
				bw.write(String.valueOf(cnt) + "\n");
			}
			//empty
			else if(cmd.equals("4")) {
				if(cnt == 0) {
					bw.write("1\n");
				}
				else {
					bw.write("0\n");
				}
			}
			//Last In 정수 출력
			else if(cmd.equals("5")) {
				if(cnt == 0) {
					bw.write("-1\n");
				}
				else {
					bw.write(stack[cnt - 1] + "\n");
				}
			}
			//push
			else {
				String push_num = cmd.split(" ")[1];
				stack[cnt] = push_num;
				cnt++;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
