import java.util.*;

class Solution {

    public int solution(int[][] jobs) {

        int total_wait_time = 0; // 총 대기 시간을 저장할 변수
        int current_time = 0; // 현재 시간, 작업이 끝난 시간을 나타냄
        int job_index = 0; // jobs 배열에서 처리할 작업의 인덱스
        int jobs_processed = 0; // 처리한 작업의 수

        // jobs 배열을 요청 시간이 빠른 순서대로 정렬 (jobs[i][0] 기준으로 오름차순 정렬)
        Arrays.sort(jobs, (job1, job2) -> job1[0] - job2[0]);

        // 수행 시간이 짧은 작업부터 처리하기 위한 우선순위 큐(최소 힙 사용)
        PriorityQueue<int[]> min_heap = new PriorityQueue<>((job1, job2) -> job1[1] - job2[1]);

        // 모든 작업을 처리할 때까지 반복
        while (jobs_processed < jobs.length) {

            // 현재 시간(current_time)까지 요청이 들어온 모든 작업을 큐에 추가
            while (job_index < jobs.length && jobs[job_index][0] <= current_time) {
                min_heap.add(jobs[job_index]);
                job_index++;
            }

            // 큐가 비어 있다면, 현재 시간 이후에 새로운 작업이 들어온다는 의미
            if (min_heap.isEmpty()) {
                // 현재 시간을 다음 작업의 요청 시간으로 설정
                current_time = jobs[job_index][0];

            } else {
                // 큐에서 가장 짧은 작업을 꺼냄 (수행 시간이 가장 짧은 작업)
                int[] current_job = min_heap.poll();

                // 대기 시간 계산: 현재 시간 - 작업의 요청 시간 + 작업의 수행 시간
                total_wait_time += current_time - current_job[0] + current_job[1];

                // 현재 시간 갱신: 작업이 끝난 시간으로 설정
                current_time += current_job[1];

                // 처리한 작업 수 증가
                jobs_processed++;
            }
        }

        // 평균 대기 시간 계산
        return total_wait_time / jobs.length;
    }
}
