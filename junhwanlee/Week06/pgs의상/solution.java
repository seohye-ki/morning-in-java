import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> h1 = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!h1.containsKey(clothes[i][1])) {
                h1.put(clothes[i][1], new ArrayList<String>());    
            }
            h1.get(clothes[i][1]).add(clothes[i][0]);
        }
        int pro = 1;
        for (String key : h1.keySet()) {
            pro *= (h1.get(key).size()+1);
        }
        return pro-1;
    }
}