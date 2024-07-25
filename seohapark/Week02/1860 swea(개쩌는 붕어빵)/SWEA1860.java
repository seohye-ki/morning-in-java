import java.util.*;

public class SWEA1860 {
		static int customer_count, mk_time, num_bung;
		static int[] guest;

		static String ganung() {
			int noshubung = 0; // 빵 몇개 있는지의 임시 카운터
			int num_tag = 0; // 몇번째 사람이 먹고 있는지에 대한 임시 카운터
			int time = 0;// *내가 시간을 멈췄다*(현재 시점을 표시)
			while (true) {
//				무한 뺑이
				while (time + mk_time > guest[num_tag]) {
//					빛보다 빠른 속도로 사람이 오는 상황에서
					if (noshubung == 0) {
						return "Impossible";
//						붕어빵 만든게 없다면.. 장사 터진거
					}noshubung--;
					if (num_tag >= (customer_count - 1)) {
//					Q. 퇴근해도 될까요(남은 사람이 있는지)
						return "Possible";
//					A1. 없으니 이제 퇴근 ㅂㅂ
					}num_tag++;
//					A2. 않되 돌아가
				}
				time += mk_time;
				noshubung += num_bung;
//				이거 while (true) 안에 들어가 있는거임 조심
//				*시간은 다시 움직이기 시작한다*
			}
		}

		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int T = input.nextInt();

			for (int t = 1; t <= T; t++) {
				customer_count = input.nextInt(); // 손님 몇명인지
				mk_time = input.nextInt(); // 그렇다면 붕어빵 만드는데 걸리는 시간은 얼마인지
				num_bung = input.nextInt(); // 자랑스러운 k-food 붕어빵이 한번에 몇개씩 만들어지는지
				guest = new int[customer_count];
				for (int i = 0; i < customer_count; i++) {
					guest[i] = input.nextInt();
				}
//				손님 리스트 작성
				Arrays.sort(guest); // 시간순으로 정렬(문제에서는 최종 결과값만 보여주면 되기에 순서 섞어도 노상관)

				System.out.printf("#%d %s\n", t, ganung());
//				가능(ganung) 함수의 결과값을 표시
			}

		}
	}

