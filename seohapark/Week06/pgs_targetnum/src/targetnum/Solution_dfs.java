package targetnum;

class Solution_dfs { 
    public int solution(int[] numbers, int target) { 
        return dfs(numbers, target, 0, 0);  // dfs 메서드 불러와줘 초기값 0에 합도 0으로 시작할게
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {  // 재귀 메서드
        if (depth == numbers.length) {  // 다 끝난 상태에서
            if (sum == target) {  //지금ㄲ싸지의 합이 목표치와 동일하다면
                return 1;  // 이 메서드 결과값은 1이야
            } else {  // 아님
                return 0;  // 말고(짜피 못만드니 gg)
            }
        } else {  // 뒤져볼게 더 있으면
            int count = 0;  // 일단 카운트값 리셋
            count += dfs(numbers, target, depth + 1, sum + numbers[depth]);  //지금 숫자 더해서 탐색, 결과값을 카운트로
         count += dfs(numbers, target, depth + 1, sum - numbers[depth]);  //지금 숫자 빼서 탐색, 결과값을 카운트로
            return count;  // 이게 우리가 원하는 값
        }
    }
}
/*
 * 지금까지의 합과 깊이를 받아와서 모든 경우를 탐색하고 마지막 인자까지 탐색
 * 메모리 사용량은 상대적으로 적을 수 있으나 스택의 깊이가 너무 깊어질지도...
 */