
import java.util.Scanner;

public class shpark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] grid = new int[N][N];
            int max = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                    max = Math.max(max, grid[i][j]);//최대값 미리 받아놓기
                }
            }

            int maxchunk = 0;

            for (int threshold = 0; threshold <= max; threshold++) {//모든 값이 0이 될때까지만 1층씩 밑에서부터 갉아먹어줘
                int[][] tmpgrid = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(grid[i][j]-threshold>0)
                        	tmpgrid[i][j]=1;
                        else
                        	tmpgrid[i][j]=0;
                    }//한계점 값보다 (i,j)의 값이 더 크다면 1 아니면 0
                }
                
                int chunktmp = 0;
                boolean[][] visited = new boolean[N][N];
                
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (tmpgrid[i][j] == 1 && !visited[i][j]) {//1인 항목이 있는데 체크가 안 되어 있다면
                            markchunk(tmpgrid, visited, i, j, N);//청크를 한번에 싸잡아주고
                            chunktmp++;//1씩 카운트(그러면 덩어리가 몇개인지가 나옴)
                        }
                    }
                }

                maxchunk = Math.max(maxchunk, chunktmp);
            }

            System.out.println("#" + t + " " + maxchunk);
        }//edoftcfor
    }//edofmain

    private static void markchunk(int[][] grid, boolean[][] visited, int x, int y, int N) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == 1 && !visited[nx][ny]) {
                markchunk(grid, visited, nx, ny, N);
            }
        }
    }
}//edofsol

