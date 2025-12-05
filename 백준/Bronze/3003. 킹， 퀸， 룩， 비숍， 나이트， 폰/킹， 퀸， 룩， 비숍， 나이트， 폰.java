import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] correct = {1, 1, 2, 2, 2, 8};
        int[] result = new int[6];

        for (int i = 0; i < 6; i++) {
            int cur = Integer.parseInt(st.nextToken());
            result[i] = correct[i] - cur;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}