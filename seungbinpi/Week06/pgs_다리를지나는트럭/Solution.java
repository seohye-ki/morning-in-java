import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
//    public static void main(String[] args) {
//    	int bridge_length = 100;
//    	int weight = 100;
//    	int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
    	
    	// 변수
        int sumWeight = 0;
        int passed = 0;
        int time = 0;
        int idx = 0;
        Queue<int[]> queue = new LinkedList<>(); // 다리 위에 있는 (트럭의무게, 들어간 시간)
        
        // 트럭이 모두 지나갈 때까지 반복
        while (passed < truck_weights.length) {
        	// 시간 증가
        	time++;
        	
        	// 다리를 다 지난 트럭은 큐에서 빼줌
        	if (queue.size()>0 && time - queue.peek()[1] == bridge_length) {
        		sumWeight -= queue.poll()[0];
        		passed++;
        	}
        	
        	// 다리에 진입할 수 있으면 큐로 들어감
        	if (idx < truck_weights.length &&
        			sumWeight + truck_weights[idx] <= weight &&
        			queue.size() < bridge_length) {
        		sumWeight += truck_weights[idx];
        		int[] arr = {truck_weights[idx++], time};
        		queue.add(arr);
        	}
        }
        
//        System.out.println(time);
        
        
        return time;
    }
}