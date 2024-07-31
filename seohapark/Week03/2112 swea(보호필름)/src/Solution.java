import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int D, W, K; // D: 행의 수, W: 열의 수, K: 연속 행의 수
    static int[][] map; // 현재 상태의 맵
    static int min; // 최소 변경 횟수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for (int test_case = 1; test_case <= TC; test_case++) {
            // 테스트 케이스에 대한 입력 읽기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken()); // 행의 수
            W = Integer.parseInt(st.nextToken()); // 열의 수
            K = Integer.parseInt(st.nextToken()); // 연속 행의 수
            map = new int[D][W]; // 맵 초기화
            min = Integer.MAX_VALUE; // 최소 변경 횟수 초기화

            // 맵 데이터 읽기
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 깊이 우선 탐색 시작
            dfs(0, 0);
            // 결과 저장
            sb.append('#').append(test_case).append(' ').append(min == Integer.MAX_VALUE ? 0 : min).append('\n');
        }

        // 결과 출력
        System.out.print(sb);
    }

    // 깊이 우선 탐색 함수
    private static void dfs(int k, int cnt) {
        // 이미 최소 변경 횟수를 넘었으면 종료
        if (cnt >= min)
            return;

        // 모든 행을 다 처리했으면 현재 맵이 조건을 만족하는지 확인
        if (k == D) {
            if (truebell()) { // 유효성 검사 함수 호출
                min = Math.min(min, cnt); // 최소 변경 횟수 갱신
            }
            return;
        }

        int[] originalRow = map[k].clone(); // 현재 행 복사

        // 변경하지 않은 경우
        dfs(k + 1, cnt);

        // A 약품 투입 (행을 0으로 설정)
        Arrays.fill(map[k], 0);
        dfs(k + 1, cnt + 1);

        // B 약품 투입 (행을 1로 설정)
        Arrays.fill(map[k], 1);
        dfs(k + 1, cnt + 1);

        // 원래 상태로 복원
        map[k] = originalRow;
    }

    // 유효성 검사 함수
    private static boolean truebell() {
        for (int i = 0; i < W; i++) { // 각 열을 확인
            int same = 1; // 현재 연속된 행의 수
            for (int j = 0; j < D - 1; j++) { // 행을 순회
                if (map[j][i] == map[j + 1][i]) {
                    same++; // 같은 값이면 연속 수 증가
                } else {
                    same = 1; // 값이 다르면 연속 수 초기화
                }

                if (same >= K) { // 연속된 수가 K 이상이면 다음 열 검사
                    break;
                }
            }
            if (same < K) return false; // 조건을 만족하지 않으면 false 반환
        }
        return true; // 모든 열이 조건을 만족하면 true 반환
    }
}