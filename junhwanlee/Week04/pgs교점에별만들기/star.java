class Solution {
    public String[] solution(int[][] line) {
        int len = line.length;
        int[][] ans = new int[len][2];
        int idx = 0;
        int intMax = Integer.MAX_VALUE;
        int maxX = -intMax;
        int maxY = -intMax;
        int minX = intMax;
        int minY = intMax;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                long x1 = line[i][0];
                long y1 = line[i][1];
                long c1 = line[i][2];
                long x2 = line[j][0];
                long y2 = line[j][1];
                long c2 = line[j][2];
                long xA = y1*c2-c1*y2;
                long yA = c1*x2-c2*x1;
                long B = x1*y2 - y1*x2;
                if (B == 0L || xA%B != 0L || yA%B != 0L) {
                    continue;
                }
                long X = xA/B;
                long Y = yA/B;
                ans[idx][0] = (int) X;
                ans[idx][1] = (int) Y;
                
                if (ans[idx][0] > maxX) {
                    maxX = ans[idx][0];
                }
                if (ans[idx][0] < minX) {
                    minX = ans[idx][0];
                }
                if (ans[idx][1] > maxY) {
                    maxY = ans[idx][1];
                } 
                if (ans[idx][1] < minY) {
                    minY = ans[idx][1];
                }
                idx++;
            }
        }
        int xLen = maxX - minX+1;
        int yLen = maxY - minY+1;
        String[][] stars = new String[yLen][xLen];
        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j <xLen; j++) {
                stars[i][j] = ".";
            }
        }
        for (int i = 0; i < idx ; i++) {
            int tmpX = ans[i][0]-minX;
            int tmpY = maxY - ans[i][1];
            stars[tmpY][tmpX] = "*";
        }
        String[] answer = new String[yLen];
        for (int i = 0; i < yLen; i++) {
            String input = "";
            for (int j = 0; j < xLen; j++) {
                input += stars[i][j];
            }
            answer[i] = input;
        }
        return answer;
    }
}