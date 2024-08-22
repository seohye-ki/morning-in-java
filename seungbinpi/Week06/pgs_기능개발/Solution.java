import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
//    public int[] solution(int[] progresses, int[] speeds) {
	public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
		
        // 큐
        Queue<Integer> queue = new LinkedList<>();
        // 정답 담을 리스트
        List<Integer> list = new ArrayList<>();
        
        // 작업 개수만큼 반복문
        for (int i=0; i<progresses.length; i++) {
        	
        	// 소요일수를 계산
        	int daysRemain = (100 - progresses[i]) / speeds[i];
        	if ((100 - progresses[i]) % speeds[i] > 0)
        		daysRemain++;
        	
        	// 큐가 비어있으면 큐에 넣기
        	if (queue.isEmpty()) {
        		queue.add(daysRemain);
        	}
        	// 소요일수 Qpeek보다 작거나 같으면 큐에 넣기
        	else if (daysRemain <= queue.peek()) {
        		queue.add(daysRemain);
        	}
        	// Qpeek보다 크면 큐 사이즈(한번에 배포하는 개수)를 정답 리스트에 추가
        	else {
        		list.add(queue.size());
        		// 큐 비워주기
        		queue.clear();
        		// 큐에 새로 넣기
        		queue.add(daysRemain);
        	}
        }
        
        // 다 끝났는데도 큐에 남아있으면 큐 사이즈(배포 개수) 정답 리스트에 추가
        if (!queue.isEmpty())
        	list.add(queue.size());
        
        // 리스트 배열로 변환
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        System.out.println(Arrays.toString(answer));
        
		
//        return answer;
    }
}