import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> progresses_q = new LinkedList<>();
        Queue<Integer> speeds_q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            progresses_q.add(progresses[i]);
            speeds_q.add(speeds[i]);
        }
        
        while(!progresses_q.isEmpty()){
            if(progresses_q.peek() >= 100){
                int cnt = 0;
                while(!progresses_q.isEmpty() && progresses_q.peek() >= 100){
                    progresses_q.poll();
                    speeds_q.poll();
                    cnt++;
                }
                answer.add(cnt);
            }
            else{
                int size = progresses_q.size();
                for(int i = 0; i < size; i++){
                    int speed = speeds_q.poll();
                    int value = progresses_q.poll() + speed;
                    progresses_q.add(value);
                    speeds_q.add(speed);
                }
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++)
            result[i] = answer.get(i);
        
        return result;
    }
}