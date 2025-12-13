import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] coins = {25, 10, 5, 1};

        for (int t = 0; t < T; t++) {
            int c = Integer.parseInt(br.readLine());
            int[] cnt = new int[4];

            for (int i = 0; i < 4; i++) {
                cnt[i] = c / coins[i];
                c %= coins[i];
            }

            sb.append(cnt[0]).append(' ')
              .append(cnt[1]).append(' ')
              .append(cnt[2]).append(' ')
              .append(cnt[3]).append('\n');
        }

        System.out.print(sb.toString());
    }
}