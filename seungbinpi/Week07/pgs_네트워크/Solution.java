class Solution {
	
	static boolean[] visit;
	static int N;
	static int[][] computer;
	
    public int solution(int n, int[][] computers) {
//	public static void main(String[] args) {
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int n = 3;
        
        // 전역변수에 저장 및 초기화 
		computer = computers;
		N = n;
		visit = new boolean[N];
		
		// 네트워크 개수 변수
		int networks = 0;
		
		// 모든 컴퓨터 순회
		for (int i=0; i<N; i++) {
			// 방문하지 않은 컴퓨터에 대해 메소드 호출
			if (!visit[i]) {
				method(i);
				networks++;
			}
		}
		// 결과 반환
//		System.out.println(networks);
        return networks;
    }
	// 연결된 컴퓨터 모두 방문하는 메소드
	static void method(int idx) {
		visit[idx] = true;
		
		// 연결된 곳이 모두 방문처리 될 때까지 방문
		for (int i=0; i<N; i++) {
			if (idx!=i && !visit[i] && computer[idx][i] == 1) {
				method(i);
			}
		}
	}
}