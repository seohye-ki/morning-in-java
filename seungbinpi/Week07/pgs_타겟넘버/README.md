설계: 13:30 ~ 13:40
코딩: 13:40 ~ 13:55

N = 배열 길이

메소드(int depth, int sum)
기저조건
depth == N
계산 값 == target이면 카운트++

2회 반복: *1 한번, *-1 한번
sum += 배열[depth] * (1 or -1)
메소드(depth+1. sum)