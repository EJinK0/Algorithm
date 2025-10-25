import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] T = new long[N];
        long maxT = 0;
        for (int i = 0; i < N; i++) {
            T[i] = Long.parseLong(br.readLine().trim());
            if (T[i] > maxT) maxT = T[i];
        }

        long lo = 0, hi = maxT * M; // 상한은 느린 1대가 전부 처리하는 시간
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2; // 안전한 중앙값
            long processed = 0;

            // mid 시간 동안 처리 가능한 총 인원
            for (int i = 0; i < N; i++) {
                processed += mid / T[i];
                if (processed >= M) break; // 조기 종료(시간/오버플로 방지)
            }

            if (processed >= M) {
                // mid 시간 안에 M명 처리 가능 → 더 줄여본다
                hi = mid;
            } else {
                // 부족 → 시간을 늘린다
                lo = mid + 1;
            }
        }

        System.out.println(lo); // 최소 시간
    }
}