import java.io.*;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 0;

        for(int i=2;i<=N;i++) {
            int best = dp[i-1] + 1;
            if(i%2==0) best = Math.min(best, dp[i/2] + 1);
            if(i%3==0) best = Math.min(best, dp[i/3] + 1);
            dp[i] = best;
        }
        System.out.println(dp[N]);
    }
}