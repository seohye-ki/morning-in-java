설계: 14:29 ~ 14:56
코딩: 14:56 ~ 15:09, 15:55 ~ 16:30

bfs
큐 만들고
첫번째 칸 큐에 넣고
visit true
distance = 1

while (큐가 빌 때까지)
    for (qpeek으로부터 8방향)
        갈 수 있는 칸이면
	visit true
	큐에 넣기
    큐 poll
    distance +1