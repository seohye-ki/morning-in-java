import java.util.HashMap;
import java.util.Set;

class Solution {

	public int solution(String[][] clothes) {
//	public static void main(String[] args) {
//		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int N = clothes.length;
		
		// 배열 순회하며 해시맵에 저장
		for (int i=0; i<N; i++) {
			String key = clothes[i][1];
			
			// 등록된 키 값이 아니면 밸류에 0 저장
			if (!map.containsKey(key))
				map.put(key, 0);
			// 해당 의상 종류 의상 개수 +1
			map.put(key, map.get(key)+1);
		}
		
		// 해시맵 키들 배열로 저장
		Set<String> set = map.keySet();
		Object[] keys = set.toArray();
		
		// 키 값 순회하며 경우의 수 계산
		int answer = 1;
		for (Object key: keys) {
			answer *= (map.get((String) key)+1);
		}
		answer--;
		
//		System.out.println(answer);
		return answer;
	}

}