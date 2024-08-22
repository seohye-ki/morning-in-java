import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)== ')') {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                if (stack.pop() == '(') {
                    continue;
                }
                answer = false;
                break;
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}