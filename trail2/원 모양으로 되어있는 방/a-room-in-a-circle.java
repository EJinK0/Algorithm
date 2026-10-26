import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        for(int start=0;start<n;start++) {
            int cost=0;

            for(int d=0;d<n;d++) {
                int idx = (start+d)%n;

                cost += arr[idx]*d;
            }

            answer = Math.min(answer, cost);
        }

        System.out.println(answer);
        sc.close();
    }
}