import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int max = 0;
        int min = 0;

        for(int i=0;i<N;i++) {
            int num = sc.nextInt();

            if(i == 0) {
                max = num;
                min = num;
                continue;
            }

            if(num > max) {
                max = num;
            } else if(num < min) {
                min = num;
            }
        }

        System.out.println(min + " " + max);
    }
}