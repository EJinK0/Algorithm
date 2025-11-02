import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line;

        while (true) {
            // x 읽기 (EOF 처리)
            line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue; // 공백 라인 건너뛰기

            int x = Integer.parseInt(line);                 // 구멍 길이(cm)
            long target = x * 10_000_000L;                  // nm로 변환
            int n = Integer.parseInt(br.readLine().trim()); // 조각 개수

            int[] a = new int[n];
            int filled = 0;
            while (filled < n) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens() && filled < n) {
                    a[filled++] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(a);

            int i = 0, j = n - 1;
            boolean found = false;
            while (i < j) {
                long sum = (long)a[i] + a[j];
                if (sum == target) {
                    out.append("yes ").append(a[i]).append(' ').append(a[j]).append('\n');
                    found = true;
                    break; // 정렬 + 투포인터 특성상 가장 차이 큰 쌍이 됨
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
            if (!found) out.append("danger\n");
        }

        System.out.print(out.toString());
    }
}