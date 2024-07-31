import java.util.Scanner;

public class saekjongi {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[100][100];
        
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            for (int row = x; row < x + 10 && row < 100; row++) {
                for (int col = y; col < y + 10 && col < 100; col++) {
                    grid[row][col] = 1;  
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                result += grid[i][j];
            }
        }
        
        System.out.println(result);
    }
}
