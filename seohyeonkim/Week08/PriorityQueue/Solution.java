import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++){
            String[] str = operations[i].split(" ");
            //삽입
            if(str[0].equals("I")){
                min.add(Integer.parseInt(str[1]));
                max.add(Integer.parseInt(str[1]));
            }
            else{
                //최댓값 삭제
                if(str[1].equals("1")){
                    if(!max.isEmpty()){
                        int num = max.poll();
                        min.remove(num);                        
                    }

                }
                //최솟값 삭제
                else{
                    if(!min.isEmpty()){
                        int num = min.poll();
                        max.remove(num);                        
                    }

                }
            }
        }

        int[] answer = new int[2];
        if(!max.isEmpty()){

            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }
}