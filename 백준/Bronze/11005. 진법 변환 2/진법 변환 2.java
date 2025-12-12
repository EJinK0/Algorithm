import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken()); // 10진수
        int B = Integer.parseInt(st.nextToken()); // 진법 (2~36)

        if (N == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            int r = (int)(N % B); // 나머지

            char c;
            if (r < 10) {
                c = (char) ('0' + r);      // 0~9
            } else {
                c = (char) ('A' + (r - 10)); // 10~35 -> A~Z
            }

            sb.append(c);
            N /= B;
        }

        // 거꾸로 쌓였으니까 뒤집기
        System.out.println(sb.reverse().toString());
    }
}