import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] a = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        int count=0;
        int target=0;

        for(int i=0;i<n;i++) {
            count += a[i];
            if(count*2 >= sum) {
                target = i;
                break;
            }
        }

        int answer =0;

        for (int i = 0; i < n; i++) {
            answer += a[i] * Math.abs(i - target);
        }

        System.out.println(answer);
        sc.close();
    }
}