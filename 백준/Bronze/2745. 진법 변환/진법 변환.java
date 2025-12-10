import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();          // 진법 수
        int B = Integer.parseInt(st.nextToken()); // 진법

        long result = 0;

        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int value;

            if (c >= '0' && c <= '9') {
                value = c - '0';
            } else { // 'A' ~ 'Z'
                value = c - 'A' + 10;
            }

            result = result * B + value;
        }

        System.out.println(result);
    }
}