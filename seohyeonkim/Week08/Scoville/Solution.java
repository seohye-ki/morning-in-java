import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int n : scoville)
            minheap.add(n);
        
        int answer = 0;
        //K보다 크거나 minheap에 1개만 들어있으면 반복문 종료
        while(minheap.peek() < K && minheap.size() > 1){
            int tmp = minheap.poll() + (minheap.poll() * 2);
            minheap.add(tmp);
            answer++;
        }
        
        //만들 수 없을때
        if(minheap.peek() < K)
            return -1;
        return answer;
    }
}