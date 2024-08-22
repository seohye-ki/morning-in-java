import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length; // 가격 배열의 길이
        int[] answer = new int[n]; // 결과를 저장할 배열
        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장할 스택
        
        for (int i = 0; i < n; i++) {
            // 현재 가격이 스택의 마지막 가격보다 낮을 때까지 처리
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop(); // 스택에서 인덱스 제거
                answer[index] = i - index; // 해당 인덱스의 가격이 떨어진 시점 계산
            }
            // 현재 인덱스를 스택에 추가
            stack.push(i);
        }
        
        // 스택에 남아있는 인덱스들 처리 (끝까지 가격이 떨어지지 않은 경우)
        while (!stack.isEmpty()) {
        int index = stack.pop(); // 스택에서 인덱스 제거
            answer[index] = n - index - 1; // 끝까지 떨어지지 않았으므로 기간 계산
        }
        
        return answer; // 결과 배열 반환
    }
}
