import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
//	public static void main(String[] args) {
//		int[] scoville = {1, 2, 3, 9, 10, 12};
//		int K = 7;
		
		// 우선순위 큐
		PriorityQueue<Long> pQueue = new PriorityQueue<>();
		
		// 배열 우선 순위 큐에 넣기
		for (int i=0; i<scoville.length; i++) {
			pQueue.add((long) scoville[i]);
		}
		
		// 섞는 횟수
		int mix = 0;
		
		// 큐 peek이 K보다 크거나 같을 때까지 반복
		while (pQueue.size()>1 && pQueue.peek() < K) {
			// 스코빌 지수 가장 작은 두개 꺼내기
			long a = pQueue.poll();
			long b = pQueue.poll();
			// 새로운 음식 만들기
			long c = a + 2*b;
			// 다시 큐에 넣기
			pQueue.add(c);
			// 섞은 횟수 +1
			mix++;
		}
		
		// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
		// 큐에 원소가 없거나
		// 큐에 원소가 하나 있는데 K보다 작은경우
		if (pQueue.isEmpty() || pQueue.peek()<K)
			mix = -1;
		
		// 결과 반환
//        System.out.println(mix);
        return mix;
    }
}