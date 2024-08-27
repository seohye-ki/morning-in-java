import java.util.*;

class Solution {
    static boolean[] visited; //티켓 사용 여부
    static String[] route; //여행경로
    static int N; //티켓 장수
    static int end_flag = 0; //종료여부
    static List<String[]> ticket = new LinkedList<>(); //ticket리스트
    
    public String[] solution(String[][] tickets) {
        //ticket list로 만들고 정렬
        for(int i = 0; i < tickets.length; i++)
            ticket.add(new String[] {tickets[i][0], tickets[i][1]});
        Collections.sort(ticket, (str1, str2) -> str1[1].compareTo(str2[1]));
        
        //static 변수 선언 및 초기화
        route = new String[tickets.length + 1];
        visited = new boolean[tickets.length];
        N = tickets.length;
        
        dfs("ICN", 0);
        return route;
    }
    
    static void dfs(String str, int cnt){
        if(cnt == N){
            end_flag = 1;
            return;
        }
        for(int i = 0; i < N; i++){
            if(end_flag == 1)
                return;
            if(visited[i] == false && match(str, ticket.get(i)[0]) == 0){
                visited[i] = true; //방문처리
                route[cnt] = str; //출발지 넣기
                route[cnt + 1] = ticket.get(i)[1]; //도착지 넣기
                dfs(ticket.get(i)[1], cnt + 1); //dfs돌기
                visited[i] = false; //초기화
            }
        }
    }
    
    static int match(String str1, String str2){
         for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i))
                return str1.charAt(i) - str2.charAt(i);
        }
        return 0;
    }
}