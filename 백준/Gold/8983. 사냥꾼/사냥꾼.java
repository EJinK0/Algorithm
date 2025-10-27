import java.io.*;
import java.util.*;

public class Main {
    static int lowerBound(int[] a, int key) {
        int lo = 0, hi = a.length; // [lo, hi)
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] >= key) hi = mid;
            else lo = mid + 1;
        }
        return lo; // 첫 a[i] >= key 의 위치 (없으면 a.length)
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] S = new int[M];                // 사대 x좌표들
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) S[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(S);

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // y가 L보다 크면 어떤 사대로도 불가능
            if (y > L) continue;

            // x에 가장 가까운 사대 후보 두 개만 체크
            int idx = lowerBound(S, x);

            boolean ok = false;
            if (idx < M) {
                // 오른쪽(또는 정확히 같은 위치)의 사대
                long dist = Math.abs((long) S[idx] - x) + y;
                if (dist <= L) ok = true;
            }
            if (!ok && idx - 1 >= 0) {
                // 왼쪽 사대
                long dist = Math.abs((long) S[idx - 1] - x) + y;
                if (dist <= L) ok = true;
            }

            if (ok) count++;
        }

        System.out.println(count);
    }
}