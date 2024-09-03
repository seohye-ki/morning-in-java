import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //들어오는 순서대로 하기
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> controller = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int time = 0;
        int idx = 0; //어떤 프로세스가 들어갈 상태인지
        int sum = 0;
        int end = 0;
        while(end < jobs.length){
            //프로세스 넣기(그 시간대에 실행 가능한 프로세스를 넣기)
            while(idx < jobs.length && jobs[idx][0] <= time){
                controller.add(new int[] {jobs[idx][0], jobs[idx][1]});
                idx++;                
            }
            
            if(!controller.isEmpty()){
                //프로세스 빼기
                int[] exec = controller.poll();
                end++;

                //프로세스 실행시키기(sum값에 더하기)
                sum += ((time - exec[0]) + exec[1]);
                time += exec[1];
            }
            else
                time++;
        }
            
        return sum / jobs.length;
    }
}