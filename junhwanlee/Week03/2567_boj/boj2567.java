import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int [N][];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            paper[i] = nums;
        }
        int answer = jong(paper, N);
        bw.write(""+answer);
        bw.flush();
        bw.close();
    }
    public static Integer jong(int[][] paper, int N) {
        int[][] wall = new int[105][105];
        for (int i = 0; i < N; i++) {
            int x = paper[i][0]+2;
            int y = paper[i][1]+2;
            for (int j = 0; j < 10; j++) {
                for (int s = 0; s < 10; s++){
                    wall[x+j][y+s] += 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <104; i++) {
            for (int j = 1; j < 104; j++) {
                if(wall[i][j] ==0 && wall[i][j-1] >= 1) ans+=1;
                if(wall[i][j] ==0 && wall[i][j+1] >= 1) ans+=1;
                if(wall[j][i] ==0 && wall[j-1][i] >= 1) ans+=1;
                if(wall[j][i] ==0 && wall[j+1][i] >= 1) ans+=1;
            }
        }
        return ans;
    }
}