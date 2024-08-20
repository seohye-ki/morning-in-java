package phonekemon;

import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> phonekemon = new HashMap<>();
        //hashmap에 폰켓몬 정보 옮기기
        for(int i = 0; i < nums.length; i++){
            //이미 있는 폰켓몬이라면
            if(phonekemon.containsKey(nums[i])){
                int value = phonekemon.get(nums[i]);
                //value + 1
                phonekemon.replace(nums[i], value + 1);                
            }
            //없으면 phonekemon에 추가
            else
                phonekemon.put(nums[i], 1);
        }
        //종류 계산하기
        int answer = 0;
        if((nums.length / 2) <= phonekemon.size())
            answer = nums.length / 2;
        else
            answer = phonekemon.size();
        return answer;
    }
}