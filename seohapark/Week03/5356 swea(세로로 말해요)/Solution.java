package swea5356;

import java.lang.reflect.Array;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
//	    테스트 케이스 몇개(cmoon) 받을거니 친구야?
	    int cmoon = input.nextInt();

//	    아래 for문은 12~37까지임 은근 범위가 기니 참고
	    for(int t = 1; t <= cmoon; t++) {
	        String[] s = new String[5];
//	        한줄한줄 줄담위로 받아오기
	        for(int i = 0; i < 5; i++) {
	            s[i] = input.next();
	        }
	        
	        int max = 0;
//	        math.max 참기 너무 힘들다..(가장 긴 열을 구해서 해당 열의 값을 추출해줌)
	        for(int i = 0; i < 5; i++) {
	            if (s[i].length() > max) {
	                max = s[i].length();
	            }
	        }
	        System.out.print("#" + t + " ");
//	        케이스 번호 붙여주고(이거 for문 안에 들어가있음!!! 주의
	        for(int i = 0; i < max; i++) {
	            for(int j = 0; j < 5; j++) {
	                if(s[j].length() <= i) {
	                    continue;
	                }
	                System.out.print(s[j].charAt(i));
	            }
//	            로직 순서
//	            1. max값만큼의 가로열을 만들어주기
//	            2. 따로 배열을 만들지 않고s[j]에 있는 문자열의 i번째 문자를 출력하는 걸 이중 포문으로 반복
	        }
	        System.out.println();
//	        빰빠까빰
	    }
	}
}
