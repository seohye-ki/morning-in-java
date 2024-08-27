import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	static String begin;
	static String target;
	static String[] words;
	
    public int solution(String BEGIN, String TARGET, String[] WORDS) {
//	public static void main(String[] args) {
//		String BEGIN = "hit";
//		String TARGET = "cog";
//		String[] WORDS = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		// static 변수에 저장
		begin = BEGIN;
		target = TARGET;
		words = WORDS;
		
		// bfs 메소드 호출
		int answer = bfs();
        
		// 결과 반환
//		System.out.println(answer);
        return answer;
    }
	static int bfs() {
		// 큐 선언
		Queue<String> qWord = new LinkedList<>();
		Queue<Integer> qCnt = new LinkedList<>();
		
		// visit 배열
		boolean[] visit = new boolean[words.length];
		
		// begin 단어 큐에 넣기
		qWord.add(begin);
		qCnt.add(0);
		
		// 큐가 빌 때까지 반복
		while(!qWord.isEmpty()) {			
			
			// words 배열의 모든 원소 순회
			for (int i=0; i<words.length; i++) { 
				// 해당 단어 방문하지 않았다면
				if (!visit[i]) {
					// 큐픽 단어와, 해당 단어 비교
					String qpeek = qWord.peek();
					String word = words[i];
					
					// 해당 단어들 char 배열로 변경
					char[] qpeek_arr = qpeek.toCharArray();
					char[] word_arr = word.toCharArray();
					
					// 다른 글자를 세기 위한 임시 변수
					int temp = 0;
					
					// 한글자씩 비교
					for (int j=0; j<word_arr.length; j++) {
						// 글자가 다르다면 카운트
						if (qpeek_arr[j] != word_arr[j]) {
							temp++;
						}
						// 2글자 이상 다르다면 종료
						if (temp >= 2)
							break;
					}
					// 모두 같거나 2글자 이상이 다르다면 continue
					if (!(temp == 1))
						continue;
					
					// 만약 이 단어가 타겟과 같다면 return
					if (word.equals(target))
						return qCnt.peek()+1;
					
					// 이외에는
					// 방문처리
					visit[i] = true;
					
					// 큐에 넣기
					qWord.add(word);
					qCnt.add(qCnt.peek()+1);
				}
			}
			// 큐에서 하나 빼기
			qWord.poll();
			qCnt.poll();
		}
		// while문을 통과했다면 0 리턴
		return 0;
	}
}