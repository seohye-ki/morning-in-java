import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int num = 100 - progresses[i];
            int day = num/speeds[i] + 1;
            if (num%speeds[i] == 0) {
                day -= 1;
            }
            queue.add(day);
        }
        int idx = queue.poll();
        int sum = 1;
        List<Integer> list = new ArrayList<>();
        if (queue.isEmpty()) {
            list.add(sum);
        }
        else {
            while(!queue.isEmpty()) {
                int can = queue.peek();
                if(queue.size() == 1) {
                    if (can <= idx) {
                        sum+= 1;
                        list.add(sum);
                    }
                    else {
                        list.add(sum);
                        sum = 1;
                        list.add(sum);
                    }
                    break;
                }
                else if (can <= idx) {
                    sum+= 1;
                    queue.poll();
                }
                else {
                    list.add(sum);
                    sum = 1;
                    idx = queue.poll();
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}