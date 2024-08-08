package pgs_교점에별만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
//  public String[] solution(int[][] line) {
  public static void main(String[] args) {
  	int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
  	
  	// 교점 저장 리스트
  	List<long[]> inter = new ArrayList<>();
  	
  	// 라인 2개 조합 모두 확인
  	for (int i=0; i<line.length-1; i++) {
  		for (int j=i+1; j<line.length; j++) {
  			int[] line1 = line[i];
  			int[] line2 = line[j];
  			long x1 = line1[0];
  			long y1 = line1[1];
  			long c1 = line1[2];
  			long x2 = line2[0];
  			long y2 = line2[1];
  			long c2 = line2[2];
  			
  			// x, y 분자 분모
  			long xNumerator = y2*c1 - y1*c2;
  			long xDenominator = y1*x2 - y2*x1;
  			long yNumerator = x2*c1 - x1*c2;
  			long yDenominator = x1*y2 - x2*y1;
  			
  			// x,y의 분모가 0이 아니고
  			if (xDenominator!=0 && yDenominator!=0) {
      			// x와 y가 정수이면
      			if (xNumerator%xDenominator==0 && yNumerator%yDenominator==0) {
      				long x = xNumerator / xDenominator;
      				long y = yNumerator / yDenominator;
      				long[] temp = {x, y};
      				inter.add(temp); // 교점 저장
      			}
  			}
  		}
  	}
  	// x, y의 최대 최소 구하기
  	// 초기 최대 최소 설정
  	long minX = inter.get(0)[0];
  	long maxX = inter.get(0)[0];
  	long minY = inter.get(0)[1];
  	long maxY = inter.get(0)[1];
  	// 교점 개수
  	int numInter = inter.size();
  	// 반복하며 최대 최소 갱신
  	for (int i=1; i<numInter; i++) {
  		if (minX > inter.get(i)[0])
  			minX = inter.get(i)[0];
  		else if (maxX < inter.get(i)[0])
  			maxX = inter.get(i)[0];
  		if (minY > inter.get(i)[1])
  			minY = inter.get(i)[1];
  		else if (maxY < inter.get(i)[1])
  			maxY = inter.get(i)[1];
  	}
  	
  	// 사각형 생성
  	String[][] plane = new String[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
  	
  	// 점 채우기
  	for (int i=0; i<maxY - minY + 1; i++) {
  		for (int j=0; j<maxX - minX + 1; j++) {
  			plane[i][j] = ".";
  		}
  	}
  	
  	// 별 채우기
  	for (int i=0; i<inter.size(); i++) {
  		long x = inter.get(i)[0];
  		long y = inter.get(i)[1];
  		plane[(int) (maxY-y)][(int) (x-minX)] = "*";
  	}
  	
  	// 이차원 배열 일차원 배열로
  	String[] answer = new String[plane.length];
  	for (int i=0; i<plane.length; i++) {
  		String oneLine = "";
  		for (int j=0; j<plane[i].length; j++) {
  			oneLine += plane[i][j];
  		}
  		answer[i] = oneLine;
  	}
  	
  	// 결과 반환     	
//      return answer;
  	
  	System.out.println(Arrays.toString(answer));
  }
}