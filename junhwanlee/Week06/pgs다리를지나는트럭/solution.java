import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        while(idx < truck_weights.length) {
            answer++;
            if (!q.isEmpty() && answer - q.peek()[1] == bridge_length) {
                sum -= q.poll()[0];
            }
            if (sum + truck_weights[idx] <= weight) {
                q.add(new int[] {truck_weights[idx], answer});
                sum += truck_weights[idx];
                idx++;
            }
        }
        answer += bridge_length;
        return answer;
    }
}