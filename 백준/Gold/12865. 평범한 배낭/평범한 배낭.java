import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물품 수
        int K = sc.nextInt(); // 최대 무게

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            int w = weights[i];
            int v = values[i];
            
            for (int j = K; j >= w; j--) {
                if (dp[j] < dp[j - w] + v) {
                    dp[j] = dp[j - w] + v;
                }
            }
        }
        System.out.println(dp[K]);
    }
}