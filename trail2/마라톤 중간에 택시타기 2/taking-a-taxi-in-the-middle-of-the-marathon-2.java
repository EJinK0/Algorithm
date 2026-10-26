import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        for(int skip=1;skip<n-1;skip++) {
            int distance=0;
            int prev=0;

            for(int i=1;i<n;i++) {
                if(i==skip) {
                    continue;
                }

                distance += Math.abs(x[prev] - x[i]) + Math.abs(y[prev]-y[i]);
                prev = i;
            }

            answer = Math.min(distance, answer);
        }

        System.out.println(answer);
        sc.close();
        // Please write your code here.
    }
}