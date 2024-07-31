import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        int xx = t%(w*2);
        int yy = t%(q*2);
        int x_A = x+xx;
        int y_A = y+yy;
        if (x_A < w+1) {
            x = x_A;
        }
        else if (x_A < 2*w+1 ) {
            x = 2*w - x_A;
        }
        else {
            x = x_A-2*w;
        }
        if (y_A < q+1) {
            y = y_A;
        }
        else if (y_A < 2*q+1 ) {
            y = 2*q - y_A;
        }
        else {
            y = y_A-2*q;
        }
        bw.write(x+" "+y);
        bw.flush();
        bw.close();
    }
}