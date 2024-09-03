import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < operations.length; i++) {
            String[] tmp= operations[i].split(" "); 
            String  play = tmp[0]; 
            int num = Integer.parseInt(tmp[1]);
            if (play.equals("I")) {
                pq1.add(num);
                pq2.add(num);
            }
            else {
                if(!pq1.isEmpty()) {
                    if(num == 1) {
                        int del = pq2.poll();
                        pq1.remove(del);
                    }
                    else {
                        int del = pq1.poll();
                        pq2.remove(del);
                    }
                }
            }
        }
        int[] answer = new int[2];
        if (!pq2.isEmpty()) {
            if(pq2.size() == 1) {
                answer[0] = pq2.poll();
                answer[1] = answer[0];
            }
            else {
                answer[0] = pq2.poll();
                answer[1] = pq1.poll();
            }
        }
        return answer;
    }
}