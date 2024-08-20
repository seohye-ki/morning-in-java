import java.util.HashMap;

class Solution {

//	public static void main(String[] args) {
	public int solution (int[] nums) {
//		int[] nums = {3, 3, 3, 2, 2, 4};
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = nums.length;
		
		// 배열 순회하며 해시맵에 저장
		for (int i=0; i<N; i++) {
			int key = nums[i];
			
			// 등록되지 않은 폰켓몬이라면 등록
			if (map.get(key) == null) {
				map.put(key, 1);
			}
		}
		
		// 최대 폰켓몬 = min(맵의 크기, N/2)
		int answer = N/2;
		if (answer > map.size())
			answer = map.size();
		
//		// 출력
//		System.out.println(answer);
		
		
		return answer;
	}

}