import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int maxR = 1, maxC = 1;

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v > max) {
                    max = v;
                    maxR = i;
                    maxC = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxR + " " + maxC);
    }
}