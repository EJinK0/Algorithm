import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isComposite = new boolean[N + 1]; // false면 소수 후보
        if (N >= 0) isComposite[0] = true;
        if (N >= 1) isComposite[1] = true;

        int limit = (int)Math.sqrt(N);
        for (int p = 2; p <= limit; p++) {
            if (!isComposite[p]) {
                // p*p 미만은 이전에 이미 지워짐
                long start = (long)p * p;
                for (long m = start; m <= N; m += p) {
                    isComposite[(int)m] = true;
                }
            }
        }

        StringBuilder out = new StringBuilder();
        for (int x = Math.max(2, M); x <= N; x++) {
            if (!isComposite[x]) out.append(x).append('\n');
        }
        System.out.print(out.toString());
    }
}