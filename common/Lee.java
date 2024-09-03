import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lee {
	static boolean[][] cheese;
	static int[] dC = { 0, 1, -1, 0 };
	static int[] dR = { 1, 0, 0, -1 };
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			cheese = new boolean[N][N];
			Map<Integer, ArrayList<int[]>> find = new HashMap<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = sc.nextInt();
					if (find.containsKey(num)) {
						find.get(num).add(new int[] { i, j });
					} else {
						find.put(num, new ArrayList<>());
						find.get(num).add(new int[] { i, j });
					}
				}
			}
			int max = 0;
			for (int i = 100; i > 0; i--) {
				if (find.containsKey(i)) {
					List<int[]> tmp = find.get(i);
					for (int j = 0; j < tmp.size(); j++) {
						int[] nums = tmp.get(j);
						cheese[nums[0]][nums[1]] = true;
					}
					int why = find();

					max = Math.max(max, why);
				}
			}
			System.out.println("#" + test + " " + max);
		}
	}

	static boolean[][] C;

	public static int find() {
		C = new boolean[N][N];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cheese[i][j] && !C[i][j]) {
					C[i][j] = true;
					del(i, j);
					answer += 1;
				}
			}
		}
		return answer;
	}

	public static void del(int c, int r) {
		for (int i = 0; i < 4; i++) {
			int CC = c + dC[i];
			int RR = r + dR[i];
			try {
				if (cheese[CC][RR] && !C[CC][RR]) {
					C[CC][RR] = true;
					del(CC, RR);
				}
			} catch (Exception e) {
				continue;
			}
		}
	}
}