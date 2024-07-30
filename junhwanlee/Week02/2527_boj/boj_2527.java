import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int p2 = sc.nextInt();
            int q2 = sc.nextInt();
            if (p2 < x1 || q2 < y1 || p1 < x2 || q1 < y2 ) {
                System.out.print("d");
            }
            else if ((x1 == p2 && y1 == q2) || (p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) || (p1 == x2 && y1 == q2)) {
                System.out.print("c");
            }
            else if(q1 == y2 || x1 == p2 || y1 == q2 || p1 == x2) {
                System.out.print("b");
            }
            else System.out.print("a");
            if (i < 3) System.out.print("\n");
        }
    }
}