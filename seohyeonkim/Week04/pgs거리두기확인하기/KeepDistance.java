package keep_distance;

import java.util.Arrays;
import java.util.Scanner;

public class KeepDistance {
	static int[] dr = {-1, 0, 1, 0}; //상좌하우 반시계
    static int[] dc = {0, -1, 0, 1}; //상좌하우 반시계
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String[][] places = new String[5][5];
    	for(int i = 0; i < 5; i++) {
    		for(int j = 0; j < 5; j++) {
    			places[i][j] = sc.next();
    		}
    	}
    	
        char[][] room = new char[5][5];
        int[] answer = new int[5];
        
        //대기실
        for(int i = 0; i < 5; i++){
            //Map에 파싱
            for(int j = 0; j < 5; j++){
                String oneline = places[i][j];
                for(int k = 0; k < 5; k++)
                    room[j][k] = oneline.charAt(k);
            }

            //유효성 판단하기
            int result = validCheck(room);
            answer[i] = result;
        }
        System.out.println(Arrays.toString(answer));
        sc.close();
    }
    
    static int validCheck(char[][] room){
        //return 1: 유효, return 0: 유효x
        
        //P를 찾으면 그 주위를 순회
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                //응시자라면 맨해튼 거리 확인
                if(room[i][j] == 'P'){
                    //P의 상하좌우 델타탐색
                    for(int k = 0; k < 4; k++){
                        int r = i + dr[k];
                        int c = j + dc[k];
                        if(0 <= r && r < 5 && 0 <= c && c < 5){
                            //다른 응시생일때
                            if(room[r][c] == 'P')
                                return 0; //붙어있어서 거리두기x
                            //빈테이블일때
                            else if(room[r][c] == 'O') {
                                //빈테이블의 상하좌우 델타탐색
                                for(int l = 0; l < 4; l++){
                                    int row = r + dr[l];
                                    int col = c + dc[l];
                                    if(row == i && col == j) //시작위치의 P는 보지 않기 위해서
                                        continue;
                                    if(0 <= row && row < 5 && 0 <= col && col < 5 && room[row][col] == 'P') //P를 만나면 유효x
                                        return 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}