import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());  // 차이 기준

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(a);

        int l = 0, r = 0;
        long ans = Long.MAX_VALUE;

        while (l < N && r < N) {
            long diff = (long) a[r] - a[l];

            if (diff >= M) {
                ans = Math.min(ans, diff);
                l++;                 // 더 작은 차이를 노리기 위해 왼쪽 포인터 증가
            } else {
                r++;                 // 차이를 키우기 위해 오른쪽 포인터 증가
            }
        }

        System.out.println(ans);
    }
}