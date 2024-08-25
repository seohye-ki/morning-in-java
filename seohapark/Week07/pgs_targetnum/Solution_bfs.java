import java.util.*;  

class Solution_bfs {  
    public int solution(int[] numbers, int target) {
        int answer = 0;  
        Queue<Integer> queue = new LinkedList<>();  // 큐에 항목 떄려박아넣고 bfs 돌릴 예정
         queue.offer(0); 

        for (int i =0;i<numbers.length;i++) { 
        	int num = numbers[i];
            int size = queue.size();  // 지금 큐의 크기를 저장
           for (int j = 0; j < size; j++) {  // size 수만큼 반복
                int current = queue.poll();  //current로 큐 0번항목 끌어오기
                queue.offer(current + num);  // 지금 값+num 큐에 추가
                 queue.offer(current - num);  // 이하동문
            }
        }

        while (!queue.isEmpty()) {  // 큐가 불타 없어질때까지
          if (queue.poll() == target) {  // 큐 0번째 들어간 값이 타겟 변수값이랑 같다면
        	   answer++;  // 가능한 경우의 수가 1개 더 추가된거랑 같음
            }
        }

        return answer;  
    }
}