import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        // 초기 창(K개)의 합
        int sum = 0;
        for (int i = 0; i < K; i++) sum += a[i];
        int max = sum;

        // 한 칸씩 오른쪽으로 이동하며 갱신
        for (int i = K; i < N; i++) {
            sum += a[i] - a[i - K];
            if (sum > max) max = sum;
        }

        System.out.println(max);
    }
}