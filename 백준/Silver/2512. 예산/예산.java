import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hi=0;
        long total=0;
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
            total += a[i];
            hi = Math.max(hi, a[i]);
        }

        long M = Long.parseLong(br.readLine());

        if(total <= M) {
            System.out.println(hi);
            return;
        }

        int lo=0;
        int ans=0;

        while(lo <= hi) {
            int mid = lo+(hi-lo) / 2;
            long need = 0;
            for(int v:a) {
                need += ( v >= mid ? mid : v);
                if (need > M) break;
            }

            if(need <= M) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}