package pgs_wordle;
//이문제는 효율검사를 안해서 통과가능
import java.util.*;

public class Solution_dfs {
    public int solution(String begin, String target, String[] words) {
        // 타겟이 words 배열에 없으면 변환 불가능
        boolean knockknock = false;
        for (String word : words) {
            if (word.equals(target)) {
                knockknock = true;
                break;
            }
        }
        if (!knockknock) {
            return 0;
        }
        
        // 방문 배열을 초기화(한 단계에서 여러개 찾는게 아니라 깊게 들어가서 가지치기를 하는거니 visited 배열을 여기서 제작
        boolean[] visited = new boolean[words.length];
        
        // DFS를 수행하여 최단 변환 단계를 찾는다
        return dfs(begin, target, words, visited, 0);
    }

    // 쭉 가지를 내려가면서 제4의 변수값에 그 기록을 저장, 그거보다 더 많이 가면 탐색 중단
    private int dfs(String now, String target, String[] words, boolean[] visited, int step) {
        // 현재 단어가 타겟 단어와 같으면 단계 반환
        if (now.equals(target)) {
            return step;
        }

        int stepcnt = Integer.MAX_VALUE; // 최단 경로를 저장할 변수
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && mergebomb(now, words[i])) {
                visited[i] = true; // 방문 처리
                int result = dfs(words[i], target, words, visited, step + 1);
                if (result != -1) {
                    stepcnt = Math.min(stepcnt, result); // 최단 경로 갱신
                }
                visited[i] = false;
            }
        }
        
        return stepcnt == Integer.MAX_VALUE ? -1 : stepcnt; // 변환 불가능한 경우 -1 반환
    }

    // 재탕은 좋은 문명
    private boolean mergebomb(String now, String word) {
        int count = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
