import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> h1 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            h1.add(nums[i]);
        }
        int answer = 0;
        int N = nums.length;
        if (h1.size() < N/2) {
            answer = h1.size();
        }
        else {
            answer = N/2;
        }
        return answer;
    }
}