import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while(pq.peek() < K && pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int tmp = num1 + (num2*2);
            pq.add(tmp);
            answer += 1;
        }
        if (pq.isEmpty() || pq.peek() < K) answer = -1;
        return answer;
    }
}