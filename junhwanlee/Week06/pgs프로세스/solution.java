import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < priorities.length ;i++) {
            q.add(new int[] {priorities[i], i});
            pq.add(priorities[i]);
        }
        int answer = 0;
        int tmp = pq.poll();
        while (!q.isEmpty()) {
            if (tmp == q.peek()[0]) {
                answer+= 1;
                int[] num = q.poll();
                if (num[1] == location) {
                    break;
                }
                tmp = pq.poll();
            }
            else {
                q.add(q.poll());
            }
        }
        return answer;
    }
}