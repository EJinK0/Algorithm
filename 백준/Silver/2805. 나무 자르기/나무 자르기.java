import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        long hi = 0;
        for(int i=0;i<N;i++) {
            A[i] = Long.parseLong(st.nextToken());
            if(A[i] > hi) hi = A[i];
        }

        long lo = 0, ans=0;
        while(lo <= hi) {
            long mid = (lo + hi) >>> 1; // (lo + hi) / 2
            long got = 0;

            for(int i=0;i<N;i++) {
                if(A[i] > mid) got += (A[i] - mid);
            }
            
            if(got >= M) {
                ans = mid;
                lo = mid+1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}