package pgs_교점에_별_만들기;

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    // 내부 클래스 포인트 
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 두 직선의 교차점을 계산
    public static Point section(long a1, long b1, long c1, long a2, long b2, long c2) {
        long denominator = a1 * b2 - a2 * b1;
        // 교차점이 없는 경우
        if (denominator == 0) {
            return null;
        }
        
        double x = (double) (b1 * c2 - b2 * c1) / denominator;
        double y = (double) (a2 * c1 - a1 * c2) / denominator;

        // x와 y가 정수인지 확인
        if (x != Math.floor(x) || y != Math.floor(y)) {
            return null;
        }
        
        return new Point((long) x, (long) y);
    }

    // 교차점 찾아조
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        // 모든 직선 쌍에 대해 교차점을 계산
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point section = section(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (section != null) {
                    points.add(section);
                }
            }
        }

        if (points.isEmpty()) {
            return new String[]{};
        }

        // 기본값(max min)
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point point : points) {
            maxX = Math.max(maxX, point.x);
            minX = Math.min(minX, point.x);
            maxY = Math.max(maxY, point.y);
            minY = Math.min(minY, point.y);
        }

        // 사이즈는 어떻게 해드릴까용
        int xLength = (int) (maxX - minX + 1);
        int yLength = (int) (maxY - minY + 1);
        char[][] map = new char[yLength][xLength];

        // 맵 리셋
        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {
                map[i][j] = '.';
            }
        }

        // 땡처리
        for (Point point : points) {
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);
            if (x >= 0 && x < xLength && y >= 0 && y < yLength) {
                map[y][x] = '*'; // y는 행, x는 열
            }
        }

        // 맵 뽑아줭
        String[] answer = new String[yLength];
        for (int i = 0; i < yLength; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}


