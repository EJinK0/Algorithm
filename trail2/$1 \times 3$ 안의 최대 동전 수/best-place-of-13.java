import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        // 가로 1 x 3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 3; j++) {

                int sum = arr[i][j]
                        + arr[i][j + 1]
                        + arr[i][j + 2];

                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);

        sc.close();
    }
}