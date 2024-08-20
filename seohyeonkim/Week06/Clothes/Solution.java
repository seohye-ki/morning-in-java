package Clothes;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        //맵으로 입력받기
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1]))
                map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
            else
                map.put(clothes[i][1], 1);
        }
        //vaule만 뽑아서 저장
        int[] cnt = new int[map.size()];
        Set<String> keys = map.keySet();
        int idx = 0;
        for(String key : keys)
            cnt[idx++] = map.get(key);
        
        //조합공식
        for(int i = 0; i < cnt.length; i++)
            answer *= (cnt[i] + 1);
        return answer - 1;
    }
}