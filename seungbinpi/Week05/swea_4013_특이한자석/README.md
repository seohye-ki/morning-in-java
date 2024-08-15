// 설계: 23:02 ~ 23:22
// 코딩: 23:22 ~ 24:04

// 크기 3의 boolean 배열: between
// between[0] = true: 0번자석 2번날 != 1번자석 6번 날
// between[1] = true: 1번자석 2번날 != 2번자석 6번 날
// between[2] = true: 2번자석 2번날 != 3번자석 6번 날

// 크기 4의 int 배열: rotation
// n번 자석 rotation 1 or -1로 변경
// between[n] = true 이면 n+1 자석 rotation -1 or 1로 변경
// between[n-1] = true 이면 n-1 자석 rotation -1 or 1로 변경

// rotation 배열 값에 따라 회전시키고
// rotation 배열은 초기화

// 시계방향 회전 메소드
// 반시계방향 회전 메소드