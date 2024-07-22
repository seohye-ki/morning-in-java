package boj18258;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Queue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int front = 0;
		int back = 0;
		int cnt = 0;
		String[] queue = new String[N];
		for(int i = 0; i < N; i++) {
			//명령어 입력받기
			String cmd = br.readLine();
			//pop : 가장앞에있는거 꺼내기
			if(cmd.equals("pop")) {
				if(cnt == 0)
					bw.write("-1\n");
				else {
					bw.write(queue[front] + "\n");
					front++;
					cnt--;
				}
			}
			//size : 몇개있는지
			else if(cmd.equals("size")) {
				bw.write(String.valueOf(cnt) + "\n");
			}
			//empty : 비어있음 1, 차있음 0
			else if(cmd.equals("empty")) {
				if(cnt == 0)
					bw.write("1\n");
				else
					bw.write("0\n");
			}
			//front : 가장 앞에있는 정수 출력
			else if(cmd.equals("front")) {
				if(cnt == 0)
					bw.write("-1\n");
				else
					bw.write(queue[front] + "\n");
			}
			//back : 가장 뒤에있는 정수 출력
			else if(cmd.equals("back")) {
				if(cnt == 0)
					bw.write("-1\n");
				else
					bw.write(queue[back - 1] + "\n");
			}
			//push
			else {
				String push_num = cmd.split(" ")[1];
				queue[back] = push_num;
				back++;
				cnt++;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
