class Solution {
    int[] dC = {1, 0, -1};
    int[] dR = {0, 1, -1};
    public int[] solution(int n) {
        int[][] sam = new int[n][];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            sam[i-1] = new int[i];
            max += i;
        }
        int num = 1;
        int idx = 0;
        int c = 0;
        int r = 0;
        sam[c][r] = num;
        while(num < max) {
            int cc = c+dC[idx%3];
            int rr = r+dR[idx%3];
            if (cc < 0 || cc >= n || rr < 0 || rr > cc) {
                idx+=1;
                continue;
            }
            else if ( sam[cc][rr] != 0) {
                idx+=1;
                continue;
            }
            c= cc;
            r= rr;
            num++;
            sam[c][r] = num;
        }
        int[] answer = new int[max];
        int II = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[II] = sam[i][j];
                II++;
            }
        }
        return answer;
    }
}