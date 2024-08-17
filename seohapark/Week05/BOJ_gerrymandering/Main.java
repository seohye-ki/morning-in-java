package BOJ_gerrymandering;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;  // 지역의 수
    static int[] pop;  // 각 지역의 인구 수를 저장하는 배열
    static List<Integer>[] adj;  // 각 지역의 인접 지역을 저장하는 리스트 배열
    static int mindiff = Integer.MAX_VALUE;  // 선거구 간 인구 차이의 최소값을 저장할 변수
    static int[] district;  // 각 지역이 속한 선거구를 저장하는 배열

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        // 지역의 수 입력
        n = sc.nextInt();

        // 배열 초기화
        pop = new int[n + 1];
        adj = new ArrayList[n + 1];
        district = new int[n + 1];

        // 인구 수 입력
        for (int i = 1; i <= n; i++) {
            pop[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }

        // 인접 지역 정보 입력
        for (int i = 1; i <= n; i++) {
            int numAdj = sc.nextInt();  // 인접한 지역의 수
            for (int j = 0; j < numAdj; j++) {
                adj[i].add(sc.nextInt());
            }
        }

        // DFS 탐색 시작
        divideDistrict(1);

        // 유효한 분할이 없으면 -1, 있으면 최소 인구 차이 출력
        if (mindiff == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(mindiff);
        }
    }

    // dfs를 활용해 선거구 나누기(n개의 지역에서가능한 모든 2^n개중의 최적해 적용)
    public static void divideDistrict(int index) {
      if (index > n) {// 모든 지역을 할당했니?
            
            if (truebell()) {// 거기에 선거구가 올바르게 나누어졌는지 확인했으면..
                calcdiff();//인구차이 계산해줭
            }
            return;
        }

        // 현재 지역을 첫 번째 선거구로 설정하고 다음 지역으로 이동
        district[index] = 1;
        divideDistrict(index + 1);
        // 현재 지역을 두 번째 선거구로 설정하고 다음 지역으로 이동
        district[index] = 2;
        divideDistrict(index + 1);
 }

    // 이거 맞는거임?
    public static boolean truebell() {
        boolean[] been = new boolean[n + 1];

        // 첫 번째 선거구와 두 번째 선거구가 각각 연결되어 있는지 확인
        int connectedComponents = 0;
        for (int i = 1; i <= n; i++) {
            if (!been[i]) {
                bfs(i, district[i], been);
                connectedComponents++;
            }
        }

        // 두 개의 연결된 선거구로 나누어진 경우에만 true 반환
        return connectedComponents == 2;
    }

    // BFS로 선거구의 연결성을 확인하는 함수(인접노드의 탐색이니 큐랑 빕스 사용)
    public static void bfs(int start, int distNum, boolean[] been) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        been[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj[current]) {
                if (!been[neighbor] && district[neighbor] == distNum) {
                    been[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // 두 선거구 간의 인구 차이를 계산하는 함수
    public static void calcdiff() {
        int tmp1 = 0, tmp2 = 0;

        // 각 선거구의 인구를 계산
        for (int i = 1; i <= n; i++) {
            if (district[i] == 1) {
                tmp1 += pop[i];
            } else {
                tmp2 += pop[i];
            }
        }

        // 인구 차이의 최소값 갱신
        int diff = Math.abs(tmp1 - tmp2);
        if (diff < mindiff) {
            mindiff = diff;
        }
    }
}
