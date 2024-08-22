import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        //큐 만들어서 넣기
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            int[] node = new int[2];
            node[0] = i;
            node[1] = priorities[i];
            queue.add(node);
        }
        
        //priorites 정렬
        Arrays.sort(priorities);
        
        //프로세스 실행
        int idx = priorities.length - 1; //우선순위 가장 높은 idx
        int cnt = 0; //실행횟수
        while(!queue.isEmpty()){
            int[] value = queue.poll(); //현재값
            //가장 우선순위가 높은지 확인
            //가장 높다면
            if(value[1] == priorities[idx]){
                cnt++; //실행 횟수 높이기
                idx--; //우선순위 가장 높은 idx
                if(value[0] == location)
                    return cnt;
            }
            //가장 높지 않다면
            else{
                queue.add(value);
            }   
        }
        return cnt;
    }
}