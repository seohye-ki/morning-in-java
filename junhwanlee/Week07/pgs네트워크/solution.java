import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    int[][] computers;
    int len;
    boolean[] net;
    public int solution(int n, int[][] computers) {
        len = computers[0].length;
        net = new boolean[computers[0].length];
        this.computers = computers;
        int answer = 0;
        for (int i = 0; i < len ; i++) {
            if (!net[i]) {
                find(computers[i], i);
                answer += 1;
            }
        }
        return answer;
    }
    
    public void find(int[] computer, int idx) {
        List<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (net[i] || i == idx) continue;
            else if (!net[i] && computer[i] == 1) {
                net[i] = true;
                tmp.add(i);
                }
            }
        for (int i = 0; i < tmp.size(); i++) {
            find(computers[tmp.get(i)], tmp.get(i));
        }
    }
}