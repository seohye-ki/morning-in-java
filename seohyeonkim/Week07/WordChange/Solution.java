import java.util.*;

class Solution {
    static boolean[] visited; //방문처리
    static int[] cnt; //변환 횟수
    
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        visited = new boolean[words.length];
        cnt = new int[words.length];
        queue.add(begin); //초기단어 큐에 넣기
                
        //bfs
        while(!queue.isEmpty()){
            String str = queue.poll(); //값 꺼내기
            
            //str이 words에서 몇번째 단어인지, 시작단어면 idx는 length!
            int idx = 0;
            while(idx < words.length){
                if(words[idx].equals(str))
                    break;
                idx++;
            }
            
            //큐에 넣은 적 없는 단어이면서 str과 1글자만 다른 단어 queue에 넣기
            for(int i = 0; i < words.length; i++){
                if(visited[i] == false && match(str, words[i]) == true){
                    visited[i] = true; //방문처리
                    if(idx != words.length)
                        cnt[i] = cnt[idx] + 1; //cnt + 1;
                    else
                        cnt[i] = 1;
                    queue.add(words[i]); //큐에 넣기
                }
            }
        }
        //target찾아서 몇번만에 바뀌는지 찾기
        int result = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                result = cnt[i];
                break;                
            }
        }
        
        //output
        return result;
    }
    
    //1글자만 다르면 true, 아니면 false
    static boolean match(String target, String compare){
        int diff = 0;
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != compare.charAt(i))
                diff++;
            if(diff > 1)
                return false;
        }
        //똑같은 경우도 false
        if(diff == 0)
            return false;
        return true;
    }
}