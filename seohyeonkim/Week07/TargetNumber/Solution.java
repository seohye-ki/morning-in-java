class Solution {
    static int answer = 0; //조합개수
    static int target_num; //target 숫자
    static int[] num_arr; //numbers 배열
    public int solution(int[] numbers, int target) {
        target_num = target;
        num_arr = numbers;
        dfs(0, 0, 0);
        return answer;
    }
    
    static void dfs(int idx, int cnt, int sum){
        if(cnt == num_arr.length){
            if(sum == target_num)
                answer++;
            return;
        }
        
        //+일때
        dfs(idx + 1, cnt + 1, sum - num_arr[idx]);

        //-일때
        dfs(idx + 1, cnt + 1, sum + num_arr[idx]);
    }
}