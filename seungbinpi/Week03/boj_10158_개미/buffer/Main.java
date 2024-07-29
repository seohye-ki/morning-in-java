package buffer;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력 및 변수설정=========================================
		String[] oneLine = new String[2];
		oneLine = br.readLine().split(" ");
		int w = Integer.parseInt(oneLine[0]);
		int h = Integer.parseInt(oneLine[1]);
		
		oneLine = br.readLine().split(" ");
		int p = Integer.parseInt(oneLine[0]);
		int q = Integer.parseInt(oneLine[1]);
		
		String time = br.readLine();		
		int t = Integer.parseInt(time);
		
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
		bw.write(Integer.toString(p));
		bw.write(" ");
		bw.write(Integer.toString(q));		
		bw.flush();
		bw.close();
		br.close();
	}
}