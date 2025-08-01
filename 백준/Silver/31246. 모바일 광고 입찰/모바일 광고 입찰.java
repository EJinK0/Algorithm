import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int K;
    static long[] adCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adCost = new long[N];

        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int my = Integer.parseInt(st.nextToken());
            int competitors = Integer.parseInt(st.nextToken());

            adCost[i] = competitors - my;
        }

        Arrays.sort(adCost);
        long result = (adCost[K-1] <= 0) ? 0 : adCost[K-1];
        System.out.println(result);
    }
}