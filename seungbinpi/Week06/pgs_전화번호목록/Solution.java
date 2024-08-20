import java.util.HashSet;

class Solution {

	public boolean solution(String[] phone_book) {
//	public static void main(String[] args) {
//		String[] phone_book = {"123","456","789"};
		
		HashSet<String> set = new HashSet<>();
		
		// 배열의 모든 원소 해시셋에 저장
		for (int i=0; i<phone_book.length; i++) {
			set.add(phone_book[i]);
		}
		
		boolean answer = true; 
		
		// 배열 모든 원소 순회
		quit:
		for (int i=0; i<phone_book.length; i++) {
			String item = phone_book[i];
			
			// 원소를 앞에서부터 길이 1~len-1 만큼 자르는 반복문
			for (int j=1; j<item.length(); j++) {
				// 자른 문자열
				String cut = item.substring(0, j);
				
				// 자른 문자열이 해시셋에 있다면 false 저장 후 반복문 종료
				if (set.contains(cut)) {
					answer = false;
					break quit;
				}
			}
		}
		
//		System.out.println(answer);
		
		return answer;
	}

}