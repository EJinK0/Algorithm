import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] g;

    // 위에서 cut행을 삭제했을 때, 남는 열 문자열들이 모두 서로 다른가?
    static boolean ok(int cut) {
        // 열별 문자열을 HashSet으로 중복 체크
        HashSet<String> set = new HashSet<>(C * 2);
        StringBuilder sb = new StringBuilder(R - cut);
        for (int c = 0; c < C; c++) {
            sb.setLength(0);
            for (int r = cut; r < R; r++) {
                sb.append(g[r][c]);
            }
            String col = sb.toString();
            if (!set.add(col)) return false; // 중복 발견
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        g = new char[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine().trim();
            g[r] = line.toCharArray();
        }

        int lo = 0, hi = R - 1, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1; // 위에서 mid행 삭제 시도
            if (ok(mid)) {             // 모두 서로 다름 → 더 많이 자를 수 있는지 시도
                ans = mid;
                lo = mid + 1;
            } else {                   // 중복 생김 → 덜 자르기
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}