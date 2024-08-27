import java.util.*;

class Solution {
    static int size;
    static List<List<int[]>> gameList, tableList;
    static boolean[][] gameMap, tableMap;
    static int[] dC = {0, 0, 1, -1};
    static int[] dR = {1, -1, 0, 0};
    static int[][] game_board, table;
    public int solution(int[][] game_board, int[][] table) {
        size = table.length;
        this.game_board = game_board;
        this.table = table;
        gameList = new ArrayList<>();
        tableList = new ArrayList<>();
        gameMap = new boolean[size][size];
        tableMap = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game_board[i][j] == 0 && !gameMap[i][j]) {
                    find('g', i, j);
                }
                if (table[i][j] == 1 && !tableMap[i][j]) {
                    find('t', i, j);
                }
            }
        }
        boolean[] use = new boolean[tableList.size()];
        int answer = 0;
        for (int i = 0; i < gameList.size(); i++) {
            List<int[]> ggg = gameList.get(i);
            boolean same = false;
            for (int j = 0; j < tableList.size(); j++) {
                if (use[j]) continue;
                List<int[]> ttt = tableList.get(j);
                if (ggg.size() != ttt.size()) continue;
                int idx = 0;
                while (!same && idx <= 4) {
                    ttt = change(ttt);
                    for (int s = 0; s < ttt.size(); s++) {
                        if(!Arrays.equals(ggg.get(s), ttt.get(s))) {
                            break;
                        }
                        if (s == ttt.size()-1) {
                            same = true;
                            use[j] = true;
                        }
                    }
                    idx++;
                }
                if (same) {
                    answer += ggg.size();
                    break;
                }
            }
        }
        return answer;
    }
    
    public void find (char word, int c, int r) {
        if (word == 'g') {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {c,r});
            gameMap[c][r] = true;
            List<int[]> gameList1 = new ArrayList<>();
            gameList1.add(new int[] {0,0});
            int min1 = 0;
            int min2 = 0;
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                int C = tmp[0];
                int R = tmp[1];
                for (int i = 0; i < 4; i++) {
                    int CC = C + dC[i];
                    int RR = R + dR[i];
                    if (CC >= size || CC < 0 || RR >= size || RR < 0) {
                        continue;
                    }
                    if (game_board[CC][RR] == 0 && !gameMap[CC][RR]) {
                        queue.add(new int[] {CC, RR});
                        gameMap[CC][RR] = true;
                        gameList1.add(new int[] {CC-c,RR-r});
                        min1 = Math.min(CC-c, min1);
                        min2 = Math.min(RR-r, min2);
                    }
                }
            }
            for (int i = 0; i < gameList1.size(); i++) {
                gameList1.get(i)[0] -= min1;
                gameList1.get(i)[1] -= min2;
            }
            gameList1.sort((a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);
            gameList.add(gameList1);
        }
        else {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {c,r});
            tableMap[c][r] = true;
            List<int[]> tableList1 = new ArrayList<>();
            tableList1.add(new int[] {0,0});
            int min1 = 0;
            int min2 = 0;
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                int C = tmp[0];
                int R = tmp[1];
                for (int i = 0; i < 4; i++) {
                    int CC = C + dC[i];
                    int RR = R + dR[i];
                    if (CC >= size || CC < 0 || RR >= size || RR < 0) {
                        continue;
                    }
                    if (table[CC][RR] == 1 && !tableMap[CC][RR]) {
                        queue.add(new int[] {CC, RR});
                        tableMap[CC][RR] = true;
                        tableList1.add(new int[] {CC-c,RR-r});
                        min1 = Math.min(CC-c, min1);
                        min2 = Math.min(RR-r, min2);
                    }
                }
            }
            for (int i = 0; i < tableList1.size(); i++) {
                tableList1.get(i)[0] -= min1;
                tableList1.get(i)[1] -= min2;
            }
            tableList1.sort((a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);
            tableList.add(tableList1);
        }
    }
    public List<int[]> change(List<int[]> ttt) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < ttt.size(); i++) {
            int num1 = ttt.get(i)[0];
            int num2 = ttt.get(i)[1];
            ttt.get(i)[1] = num1;
            ttt.get(i)[0] = 5-num2;
            min1 = Math.min(min1, ttt.get(i)[0]);
            min2 = Math.min(min2, ttt.get(i)[1]);
        }
        for (int i = 0; i < ttt.size(); i++) {
            ttt.get(i)[0] -= min1;
            ttt.get(i)[1] -= min2;
        }
        ttt.sort((a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);
        return ttt;
    }
}