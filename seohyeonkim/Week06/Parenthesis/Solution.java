import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            //여는 괄호일때 stack에 넣기
            if(s.charAt(i) == '(')
                stack.push(s.charAt(i));
            //닫는 괄호일때
            else{
                //stack에 들어있는게 없을때
                if(stack.isEmpty() == true)
                    return false;
                //여는 괄호 하나 꺼내기
                else
                    stack.pop();
            }
        }
        //남아있는 괄호가 없으면 true
        if(stack.isEmpty() == true)
            return true;
        //남아있는 괄호가 있으면 false
        else
            return false;
    }
}