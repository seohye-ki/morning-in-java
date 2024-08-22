import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for (int i = 0; i <prices.length; i++) {
            if(!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                while(!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                    answer[stack.peek()[1]] = i-stack.pop()[1];
                }
            }
            stack.push(new int[] {prices[i], i});
        }
        if (!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                answer[stack.peek()[1]] = prices.length - 1 - stack.pop()[1];
            }
        }
        return answer;
    }
}