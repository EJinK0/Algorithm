import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        st = new StringTokenizer(br.readLine());
        long lo = 0;
        long hi = 0;
        for(int i=0;i<N;i++) {
            a[i] = Integer.parseInt(st.nextToken());
            lo = Math.max(lo, a[i]);
            hi += a[i];
        }

        long ans = hi;

        while(lo <= hi) {
            long mid = lo + (hi-lo)/2;
            if(canFit(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid+1;
            }
        }

        System.out.println(ans);
    }

    static boolean canFit(long cap) {
        int disks = 1;
        long cur = 0;

        for(int x: a) {
            if(cur + x <= cap) {
                cur += x;
            } else {
                disks++;
                cur=x;
            }
        }
        return disks <= M;
    }
}