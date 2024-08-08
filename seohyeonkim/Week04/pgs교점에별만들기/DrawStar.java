package draw_star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DrawStar {
	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int[][] line = new int[3][3];
	      	for(int i = 0; i < 3; i++) {
	    		for(int j = 0; j < 3; j++) {
	    			line[i][j] = sc.nextInt();
	    		}
	    	}
	    	
	        ArrayList<int[]> star = new ArrayList<>();
	      //모든 조합 확인해보기
	        for(int i = 0;  i < line.length; i++){
	            for(int j = i + 1; j < line.length; j++){
	                long[] f1 = new long[3];
	                long[] f2 = new long[3];
	                for(int k = 0; k < 3; k++){
	                    f1[k] = line[i][k];
	                    f2[k] = line[j][k];
	                }
	                //교점 구하기
	                long N = (f1[0] * f2[1]) - (f1[1] * f2[0]);
	                if(N == 0) // AD - BC = 0 평행이거나 일치하는 경우
	                    continue;
	                long xN = (f1[1] * f2[2]) - (f1[2] * f2[1]); // BF - ED / AD - BC
	                long yN = (f1[2] * f2[0]) - (f1[0] * f2[2]); // EC - AF / AD - BC
	                if(xN % N == 0 && yN % N == 0) { //가능한 좌표
	                    int x = (int)(xN / N);
	                    int y = (int)(yN / N);
	                    star.add(new int[] {(int)x,(int)y});
	                }

	            }
	        }
	        
	        for(int i = 0; i < star.size(); i++)
	        	System.out.println("x : " + star.get(i)[0] + " y : " + star.get(i)[1]);
	        
	        //열 최대/최소, 행 최대/최소 구하기
	        int xMin = star.get(0)[0];
	        int xMax = star.get(0)[0];
	        int yMin = star.get(0)[1];
	        int yMax = star.get(0)[1];
	        for(int i = 0; i < star.size(); i++) {
	        	if(star.get(i)[0] < xMin)
	        		xMin = star.get(i)[0];
	        	if(xMax < star.get(i)[0])
	        		xMax = star.get(i)[0];
	        	if(star.get(i)[1] < yMin)
	        		yMin = star.get(i)[1];
	        	if(yMax < star.get(i)[1])
	        		yMax = star.get(i)[1];
	        	System.out.println("xMin : " + xMin + " xMax : " + xMax + " yMin : " + yMin + " yMax : " + yMax);
	        }
	        
	        //map 열과 행 구하기
	        int x = xMax - xMin + 1;
	        int y = yMax - yMin + 1;
	        System.out.println("x : " + x + " y : " + y);
	        
	        //map 생성 및 초기화
	        String[][] map = new String[y][x];
	        for(int i = 0; i < y; i++)
	        	Arrays.fill(map[i], ".");
	        System.out.println(Arrays.deepToString(map));
	        
	        //map에 별찍기
	        for(int i = 0; i < star.size(); i++) {
	        	int col = Math.abs(xMin - star.get(i)[0]);
	        	System.out.println("col : " + col);
	        	
        		int row = Math.abs(yMin + star.get(i)[1]);
	        	System.out.println("row : " + row);
        		map[y - 1 - row][col] = "*";
        	}
	        System.out.println(Arrays.deepToString(map));
	        
	        //answer에 넣기
	        String[] answer = new String[y];
	        for(int i = 0; i < y; i++) {
	        	answer[i] = map[i][0];
	        	for(int j = 1; j < x; j++) {
	        		answer[i] += map[i][j];
	        	}
	        }
	        
	        System.out.println(Arrays.toString(answer));
	        sc.close();
	    }
}
