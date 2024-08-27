설계: 16:33 ~ 16:43
코딩: 16:43 ~ 17:12

bfs
큐 만들기
큐에 begin 단어 넣기

while (큐가 빌 때까지)
    for (words의 모든 원소 순회)
        if Qpeek 단어와 해당 단어가 한글자 차이이고
	방문하지 않았으면
	방문 처리
	큐에 넣기, 단어 바꾼 횟수와 함께
	이때 이 단어가 target과 같으면 바꾼 횟수 return
    큐 poll

while 문 통과했으면 0 return