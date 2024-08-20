package NotFinishTheRace;

import java.util.HashMap;
import java.util.Set;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> player = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            //중복이면 value++
            if(player.containsKey(participant[i])){
                int value = player.get(participant[i]);
                player.replace(participant[i], value + 1);
            }
            //없으면 데이터 추가
            else
                player.put(participant[i], 1);
        }
        //완주한사람 제외
        for(int i = 0; i < completion.length; i++){
            //동명이인 있으면
            if(player.get(completion[i]) != 1){
                player.replace(completion[i], player.get(completion[i]) - 1);
            }
            //동명이인 없으면
            else
                player.remove(completion[i]);
        }
        //마지막 남은 값 뽑아내기
        Set<String> key = player.keySet();
        String answer = key.iterator().next();
        return answer;
    }
}
