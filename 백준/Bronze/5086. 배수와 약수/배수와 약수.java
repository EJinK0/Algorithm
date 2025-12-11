import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break; // 종료 조건
            }

            if (b % a == 0) {
                sb.append("factor");
            } else if (a % b == 0) {
                sb.append("multiple");
            } else {
                sb.append("neither");
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}