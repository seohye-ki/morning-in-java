package boj10158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ant {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String tmp = br.readLine();
		int width = Integer.parseInt(tmp.split(" ")[0]);
		int height = Integer.parseInt(tmp.split(" ")[1]);
		tmp = br.readLine();
		int x = Integer.parseInt(tmp.split(" ")[0]);
		int y = Integer.parseInt(tmp.split(" ")[1]);
		int time = Integer.parseInt(br.readLine());
		
		int tmpX = time % (width * 2);
		int tmpY = time % (height * 2);

		if(x + tmpX >= (width * 2))
			x = (x + tmpX) - (width * 2);
		else if(x + tmpX >= width)
			x = (width * 2) - (x + tmpX);
		else
			x = x + tmpX;
		if(y + tmpY >= (height * 2))
			y = (y + tmpY) - (height * 2);
		else if(y + tmpY >= height)
			y = (height * 2) - (y + tmpY);
		else
			y = y + tmpY;
		
		bw.write(x + " " + y);
		bw.flush();
		bw.close();
		br.close();
	}
}
