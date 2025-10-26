import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 조카 수
        int N = Integer.parseInt(st.nextToken()); // 과자 개수

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        long hi = 0; // 가능한 최대 길이(과자 최대 길이)
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
            if (A[i] > hi) hi = A[i];
        }

        long lo = 1;      // 길이 0은 의미 없으니 1부터
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2; // 후보 길이 L
            long pieces = 0;

            for (int i = 0; i < N; i++) {
                pieces += A[i] / mid;
                if (pieces >= M) break; // 충분하면 조기 종료
            }

            if (pieces >= M) { // 배분 가능 → 길이를 더 늘려본다
                ans = mid;
                lo = mid + 1;
            } else {           // 배분 불가 → 길이를 줄인다
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}