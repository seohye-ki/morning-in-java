import java.util.Stack;

class Solution {
    boolean solution(String s) {
//	public static void main(String[] args) {
//		String s = "(()(";
		
		// 결과 변수
		boolean answer = true;
		
		// 스택
		Stack<Character> stack = new Stack<>();
		
		// 문자열 길이만큼 반복문
		for (int i=0; i<s.length(); i++) {
			// 문자 하나씩 받기
			char c = s.charAt(i);
			
			// 여는괄호 `(` 일 때
			if (c == '(')
				stack.push(c);
			// 닫는괄호 `)` 일 때
			else {
				// 스택이 비어있으면 false, 종료
				if (stack.isEmpty()) {
					answer = false;
					break;
				}
				// 스택 top이 닫는 괄호 `)`이면 false, 종료
				else if (stack.peek() == ')') {
					answer = false;
					break;
				}
				// 스택 top이 여는 괄호 `(`이면 pop
				stack.pop();
			}
		}
		// 반복문 끝나고도 스택이 비어있지 않으면 false
		if (!stack.isEmpty())
			answer = false;
		
//        System.out.println(answer);

        return answer;
    }
}