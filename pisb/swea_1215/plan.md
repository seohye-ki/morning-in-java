1. 2차원 char 배열에 input 입력
    - 1행씩 String으로 input 받기
    - 1글자씩 쪼개서 2차원 string 배열 담기

2. 0~(8-N) 이중 반복문으로 가로 검사
    - 0~(N/2) 반복문 (총 삼중 반복)
    - `alphabets[i][j] == alphabets[i][j+N-1-i]`
    - 성립하면 count += 1

3. 2. 0~(8-N) 이중 반복문으로 세로 검사