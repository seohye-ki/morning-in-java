import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cham = sc.nextInt();
        int[] dir = new int[12];
        int[] len = new int[12];
        for (int i = 0; i < 6; i++) {
            dir[i] = sc.nextInt();
            len[i] = sc.nextInt();            
        }
        for (int i = 0; i < 6; i++) {
            dir[i+6] = dir[i];
            len[i+6] = len[i];
        }
        int ans = 0;
        for (int j = 0; j <9; j++) {
            if (dir[j] == dir[j+2] && dir[j+1] == dir[j+3]) {
                if (j > 3) {
                    ans += len[j-2]*len[j-1];
                }
                else {
                    ans += len[j+4]*len[j+5];
                }
                ans-= len[j+1]*len[j+2];
                break;
            }
        }
        System.out.println(ans*cham);
    }
}