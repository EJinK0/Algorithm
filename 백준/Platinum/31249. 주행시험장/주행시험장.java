import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            if (n > m) { long tmp = n; n = m; m = tmp; }

            long k, moves;
            if (n == 1 && m == 3) {
                k = 2;
                moves = 5;
            } else if (n == m) {
                k = n;
                moves = 3;
            } else if (m <= 2 * n) {
                k = n;
                moves = 7;
            } else if (m == 2 * n + 1 || m == 2 * n + 2) {
                k = n + 1;
                moves = 7;
            } else {
                k = n + 1;
                moves = 7 + 2 * (m - (2 * n + 2));
            }
            sb.append(k).append(" ").append(moves).append("\n");
        }
        System.out.print(sb);
    }
}