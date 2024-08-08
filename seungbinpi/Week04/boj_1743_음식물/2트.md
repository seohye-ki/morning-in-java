static 변수
- boolean[N][M] floor
- boolean[N][M] visit
- int[4] dc {0, 1, 0, -1}
- int[4] dr {1, 0, -1, 0}
- int size // 음식물 사이즈

dfs 메소드
for 문 반복 네방향
음식물 발견시 dfs 재귀
방문한 곳은 visit에 저장

main 메소드
N, M 입력
음식물 위치 입력 (인덱스 = 입력값 - 1)