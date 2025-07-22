import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(a == 0 && b == 0 && c == 0) {
                break;
            }

            int[] slids = {a, b, c};
            Arrays.sort(slids);

            if(slids[0]*slids[0] + slids[1]*slids[1] == slids[2]*slids[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}