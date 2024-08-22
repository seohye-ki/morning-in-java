import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        
        int cnt = 0; //통과한 트럭 수
        int in_idx = 1; //추가하는 트럭 인덱스
        int out_idx = 0; //나가는 트럭 인덱스
        
        //초기화
        int time = 1; //경과 시간
        int total_weight = truck_weights[0]; //다리를 건너는 트럭 무게 합산
        queue.add(1); //큐에 첫번째 트럭 넣기
        
        while(cnt != truck_weights.length){
            //다리에서의 위치 1칸씩 이동
            int size = queue.size();
            for(int i = 0; i < queue.size(); i++){
                queue.add(queue.poll() + 1);
            }
            //나갈 트럭있는지 확인하고 내보내기
            if(queue.peek() > bridge_length){
                queue.poll(); //트럭 내보내기
                cnt++; //통과한 트럭 수 +1
                total_weight -= truck_weights[out_idx];
                out_idx++;
            }
            //무게를 넘지 않는다면 트럭추가
            if(in_idx < truck_weights.length && total_weight + truck_weights[in_idx] <= weight){
                queue.add(1);
                total_weight += truck_weights[in_idx];
                in_idx++;
            }
            time++;
        }
        return time;
    }
}