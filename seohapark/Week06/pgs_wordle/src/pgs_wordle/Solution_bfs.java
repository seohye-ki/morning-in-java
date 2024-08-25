package pgs_wordle;

import java.util.*;

public class Solution_bfs {
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
        
        return bfs(begin, target, words);
    }

    // 하나를 파고드는게 아니라 여러 세계선 중 제일 짧고 쉬운거 찾느거니 bfs 쓰는게 좋음
     private int bfs(String begin, String target, String[] words) {
        int n = words.length;
        Queue<String[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n]; // 내가 여길 왔던가?
        
        queue.offer(new String[]{begin, "0"}); // 시작 단어와 단계 0으로 초기화
        
        while (!queue.isEmpty()) {
            String[] current = queue.poll();
            String now = current[0];
            int step = Integer.parseInt(current[1]);
            
            // 현재 단어가 타겟 단어와 같으면 단계 반환
            if (now.equals(target)) {
                return step;
            }
            for (int i = 0; i < n; i++) {
                // 왔다면 손절
                if (visited[i]) {
                    continue;
                }
                
                String word = words[i];
                // 현재 단어와 체크할 단어가 한 글자만 다른 경우(머지했을 때 터지기 제일 쉬운 경우인지)
                if (mergebomb(now, word)) {
                    visited[i] = true; // 방문 처리
                    queue.offer(new String[]{word, String.valueOf(step + 1)}); // 단계 증가
                }
            }
        }
        
        return 0; // 아니라면 이건 개노답
    }

    // 딱 한글자만 다른지 체크
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
