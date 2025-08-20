import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        long[] coin = new long[N];
        for(int i = 0; i < N; i++) {
            coin[i] = Long.parseLong(br.readLine());
        }
        
        long cnt = 0;
        for(int i=N-1 ; i>=0 ; i--) {
            if(coin[i] <= M) {
                cnt += M / coin[i];
                M %= coin[i];
            }
            if (M == 0) break;
        }
        
        System.out.println(cnt);
    }
}