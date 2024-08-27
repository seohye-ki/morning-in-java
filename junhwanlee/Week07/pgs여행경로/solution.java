import java.util.*;

class Solution {
    static int N;
    public String[] solution(String[][] tickets) {
        HashMap<String, List<String>> h1 = new HashMap<>();
        N = tickets.length+1;
        for(int i = 0; i<tickets.length; i++) {
            if (!h1.containsKey(tickets[i][0]))
                h1.put(tickets[i][0],new ArrayList<>());
            h1.get(tickets[i][0]).add(tickets[i][1]);
        }
        Set<String> S = h1.keySet();
        for(String word : S) {
            String[] words = h1.get(word).toArray(new String[0]);
            Arrays.sort(words);
            h1.put(word, new ArrayList<>(Arrays.asList(words)));
        }
        
        List<String> we = new ArrayList<>();
        List<String> FIND = find (h1, we, "ICN", 0);
        String[] answer = FIND.toArray(new String[0]);
        return answer;
    }
    
    public List<String> find (HashMap<String, List<String>> h1, List<String> we, String air, int count) {
        if (count == N) {
            return we;
        }
        List<String> weCopy = new ArrayList<>(we);
        weCopy.add(air);
        count+= 1;
        int idx = 1;
        String AIR = h1.get(air).get(0);
        for (int i = 0; i < h1.get(air).size(); i++) {
            if (i != 0 && AIR.equals(h1.get(air).get(i))) continue;
            AIR = h1.get(air).get(i);
            if (!h1.containsKey(AIR) || h1.get(AIR).isEmpty()) {
                if (count == N-1) {
                    weCopy.add(AIR);
                    return weCopy;
                }
                continue;
            }
            h1.get(air).remove(i);
            List<String> FIND = find(h1, weCopy, AIR, count);
            h1.get(air).add(i, AIR);
            if (FIND.size() == N) {
                weCopy = FIND;
                break;
            }                
        }
        return weCopy;
    }
}