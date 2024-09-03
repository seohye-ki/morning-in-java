import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < jobs.length; i++) {
            int[] tmp = new int[] {jobs[i][0], jobs[i][1]};
            if(map.containsKey(tmp[0])) {
                map.get(tmp[0]).add(tmp[1]);
            }
            else {
                map.put(tmp[0], new PriorityQueue<>());
                map.get(tmp[0]).add(tmp[1]);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int count = 0;
        int t = 0;
        int time = 0;
        while (count < jobs.length) {
            if(map.containsKey(t)) {
                for (int num : map.get(t)) {
                    pq.add(new int[] {t , num});    
                }
            }
            if(!pq.isEmpty()) {
                int[] p = pq.poll();
                int idx = 0;               
                count++;
                for (int i = t+1; i < t+p[1]; i++) {
                    if(map.containsKey(i))
                        for (int num : map.get(i)) 
                            pq.add(new int[] {i , num});    
                }
                t += p[1];
                time += t - p[0];
            }
            else {
                t++;
            }
            
        }
        
        int answer = time/count;
        return answer;
    }
}