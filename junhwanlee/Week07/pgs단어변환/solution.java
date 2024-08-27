
class Solution {

    // 전역 변수 words, target 설정
    static String[] words;
    static String target;
    public int solution(String begin, String target, String[] words) {
        
        // 전역 변수에 값 할당
        this.words = words;
        this.target = target;

        // 방문 여부 파악하는 v 생성
        boolean[] v = new boolean[words.length];

        // 정답 찾아 떠나자
        int answer = find(begin, 0, v);

        // 정답이 예외 값일 때 (51) 변환할 수 없으므로 0
        if (answer == 51) answer = 0;

        // 정답 출력
        return answer;
    }
    
    // 메서드 find
    public int find(String word, int count, boolean[] v) {
        
        // 단어 1개만 다를 때 그 단어로 변환하여 재귀, 모든 경우 중 min 출력
        int min = 51;
        for (int j = 0; j <words.length; j++) {
            int t = 0;
            if (!v[j]) {
                String s = words[j];
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) != word.charAt(i)) t += 1;
                    if (t > 1) break;
                }
                if (t == 1) {
                    if (s.equals(target)) return count+1;
                    v[j] = true;
                    int MIN = find(s, count+1, v);
                    min = Math.min(min, MIN);
                    v[j] = false;
                }   
            }
        }
        return min;
    }
}