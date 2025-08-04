import java.io.*;
import java.util.*;
public class Main {
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(binomial(N,M));
    }

    private static int binomial(int n, int k) {
        if(k<0||k>n) return 0;
        if(k==0||k==n) return 1;

        k= Math.min(k, n-k);
        long result = 1;
        for(int i=1;i<=k;i++) {
            result = result * (n-i+1)/i;
        }
        return (int) result;
    }
}