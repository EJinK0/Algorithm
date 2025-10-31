import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        int l = 0, r = N - 1;
        long bestAbs = Long.MAX_VALUE;
        int ansL = a[l], ansR = a[r];

        while (l < r) {
            long sum = (long)a[l] + a[r];
            long abs = Math.abs(sum);

            if (abs < bestAbs) {
                bestAbs = abs;
                ansL = a[l];
                ansR = a[r];
                if (bestAbs == 0) break; // 최적
            }

            if (sum < 0) l++;
            else r--;
        }

        System.out.println(ansL + " " + ansR);
    }
}