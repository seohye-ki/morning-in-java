class Solution {
    int[] dC = {1, -1, 0, 0};
    int[] dR = {0, 0, 1, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            String[] place = places[i];
            answer[i] = find(place);
        }
        return answer;
    }
    public Integer find (String[] place) {
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(place[i].charAt(j) == 'P') {
                    if (del(i,j,place) == 0) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    public Integer del (int i, int j, String[] place) {
        for (int s = 0; s < 4; s++) {
            int c = i+dC[s];
            int r = j+dR[s];
            if (0 <= c && c < 5 && 0 <= r && r < 5) {
                if (place[c].charAt(r) == 'P') {
                    return 0;
                }
                if(place[c].charAt(r) == 'O') {
                    for (int t = 0; t < 4; t++) {
                        int y = c + dC[t];
                        int x = r + dR[t];
                        if (!(x == j && y == i )&& 0 <= y && y < 5 && 0 <= x && x < 5) {
                            if(place[y].charAt(x) == 'P') {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}