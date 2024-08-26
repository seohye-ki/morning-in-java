class Solution {
	
	// static 변수
	static int[] arr;
	static int target2;
	static int answer;
	static int N;
	
    public int solution(int[] numbers, int target) {
//    public static void main(String[] args) {
//    	int[] numbers = {1, 1, 1, 1, 1};
//    	target = 3;
    	
    	arr = numbers;
    	target2 = target;
    	
    	// N = 배열의 길이
    	N = arr.length; 
    	
    	// 초기화 후 dfs 메소드 호출
    	answer = 0;
    	dfs(0, 0);
    	
    	// 결과 출력
//    	System.out.println(answer);
        return answer;
    }
    
    // dfs 메소드
    static void dfs(int depth, int sum) {
    	// 기저 조건
    	if (depth == N) {
    		if (sum == target2)
    			answer++;
    		return;
    	}
    	
    	// 재귀
    	for (int i=-1; i<=1; i+=2) {
    		int newSum = sum + arr[depth] * i;
    		dfs(depth+1, newSum);
    	}
    }
}