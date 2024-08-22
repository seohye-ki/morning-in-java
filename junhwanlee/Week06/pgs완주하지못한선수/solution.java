import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> h1 = new HashMap<>();
        for (int i = 0; i <participant.length; i++) {
            h1.put(participant[i] ,h1.getOrDefault(participant[i], 0)+1);
        }
        for (int i = 0; i < completion.length; i++) {
            if ( h1.get(completion[i]) == 1) {
                h1.remove(completion[i]);
            }
            else {
                h1.put(completion[i], h1.get(completion[i]) - 1);
            }
        }
        String answer = "";
        for (String pe : h1.keySet()) {
            answer += pe;
        }
        return answer;
    }
}